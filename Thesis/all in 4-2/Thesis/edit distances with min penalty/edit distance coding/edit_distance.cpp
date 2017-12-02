#include <bits/stdc++.h>

#define ms(a,b) memset(a,b,sizeof(a))
#define inf 1<<30
#define mp make_pair
#define pi acos(-1)
#define pii pair<int,int>
#define pll pair<ll,ll>
#define pli pair<ll,int>
#define pil pair<int,ll>
#define fs first
#define sc second
#define cffi ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define pob pop_back
#define vec_ vector
#define clr(a) a.clear()
#define pb push_back
#define eps 1E-7
#define all(a) a.begin(),a.end()
#define allr(a) a.rbegin(),a.rend()
#define sz(a) (int)a.size()
#define ll long long
#define ull unsigned long long
#define dd double
#define rep(i,n) for(i=0;i<n;i++)
#define rep1(i,n) for(i=1;i<=n;i++)
using namespace std;

template<class T1> void deb(T1 e)
{
    cout<<e<<endl;
}
template<class T1,class T2> void deb(T1 e1,T2 e2)
{
    cout<<e1<<" "<<e2<<endl;
}
template<class T1,class T2,class T3> void deb(T1 e1,T2 e2,T3 e3)
{
    cout<<e1<<" "<<e2<<" "<<e3<<endl;
}
template<class T1,class T2,class T3,class T4> void deb(T1 e1,T2 e2,T3 e3,T4 e4)
{
    cout<<e1<<" "<<e2<<" "<<e3<<" "<<e4<<endl;
}
template<class T1,class T2,class T3,class T4,class T5> void deb(T1 e1,T2 e2,T3 e3,T4 e4,T5 e5)
{
    cout<<e1<<" "<<e2<<" "<<e3<<" "<<e4<<" "<<e5<<endl;
}
template<class T1,class T2,class T3,class T4,class T5,class T6> void deb(T1 e1,T2 e2,T3 e3,T4 e4,T5 e5,T6 e6)
{
    cout<<e1<<" "<<e2<<" "<<e3<<" "<<e4<<" "<<e5<<" "<<e6<<endl;
}


#define mt 1005
#define mod

#define fop freopen("reference_genome.txt","r",stdin);
#define fop2 freopen("sam_to_normal_read.txt","r",stdin);freopen("after_edit_distance.txt","w",stdout);

int dp[mt][mt];
string arr1,arr2;

int solve(int pos1,int pos2)
{
    if(pos1 >= sz(arr1))
        return sz(arr2)-pos2;
    if(pos2 >=sz(arr2))
        return sz(arr1)-pos1;

    int &ret=dp[pos1][pos2];
    if(ret != -1)
        return ret;
    ret=inf;
    if(arr1[pos1] == arr2[pos2])
        ret=min(ret,solve(pos1+1,pos2+1));
    if(arr1[pos1] != arr2[pos2])
        ret=min(ret,1+solve(pos1+1,pos2+1));
    ret=min(ret,1+solve(pos1+1,pos2));
    ret=min(ret,1+solve(pos1,pos2+1));
    return ret;
}

string ans;

void solve2(int pos1,int pos2)
{
    if(pos1 >= sz(arr1))
        {
            for(int i=pos2;i<sz(arr2);i++)
            {
                ans+='-';
                ans+=arr2[pos2];
            }
            return;
        }
    if(pos2 >=sz(arr2))
        {
            for(int i=pos1;i<sz(arr1);i++)
            {
                ans+=arr1[pos1];
                ans+='-';
            }
            return;
        }
    int ret=dp[pos1][pos2];
    if(ret == solve(pos1+1,pos2+1) && arr1[pos1]==arr2[pos2])
    {
        ans+=arr1[pos1];
        ans+=arr2[pos2];
        solve2(pos1+1,pos2+1);
        return;
    }
    if(ret == 1+solve(pos1+1,pos2+1) && arr1[pos1]!=arr2[pos2])
    {
        ans+='-';
        ans+='-';
        solve2(pos1+1,pos2+1);
        return;
    }
    if(ret == 1+solve(pos1+1,pos2))
    {
        ans+=arr1[pos1];
        ans+='-';
        solve2(pos1+1,pos2);
        return;
    }
    if(ret == 1+solve(pos1,pos2+1))
    {
        ans+='-';
        ans+=arr2[pos2];
        solve2(pos1,pos2+1);
    }
}


int main ()
{
    cffi;
    fop;
    int i,j,test,n,t=1,pos;
    string ref_gen;
    cin>>ref_gen;
    fclose(stdin);
    fop2;
    int c=1;
    while(cin>>pos>>arr2)
    {
        arr1=ref_gen.substr(pos,sz(arr2));
        ms(dp,-1);
        solve(0,0);
        clr(ans);
        solve2(0,0);
        deb(c++,sz(arr2),ans);
        cout<<endl<<endl;
    }
    return 0;
}










