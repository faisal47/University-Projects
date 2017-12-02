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
#define fop2 freopen("sam_to_normal_read_with_ref_length.txt","r",stdin);freopen("after_edit_distance.txt","w",stdout);

int dp[mt][mt];
string arr1,arr2;

int match_value=-5;
int mis_match_value=4;
int gap_value=6;
int gap_open=2;

void solve()
{
    int i,j;
    rep(i,sz(arr1)+1)
    rep(j,sz(arr2)+1)
    {
        dp[i][j]=inf;
        if(i==0 && j==0)
        {
            dp[i][j]=0;
            continue;
        }
        else if(j==0)
            dp[i][j]=i*gap_value;
        else if(i==0)
            dp[i][j]=j*gap_value;
        else
        {
            if(arr1[i-1] == arr2[j-1])
                dp[i][j]=min(dp[i][j],match_value+dp[i-1][j-1]);
            else if(arr1[i-1] != arr2[j-1])
                dp[i][j]=min(dp[i][j],mis_match_value+dp[i-1][j-1]);
            dp[i][j]=min(dp[i][j],gap_value+dp[i-1][j]);
            dp[i][j]=min(dp[i][j],gap_value+dp[i][j-1]);
        }
    }
}

string ans;
void solve2()
{
    clr(ans);
    int i=sz(arr1);
    int j=sz(arr2);
    int mini;
    while(i>0 || j>0)
    {
//        deb(i,j);
        if(i>0 && dp[i][j]==gap_value+dp[i-1][j])
        {
            ans+='-';
            ans+=arr1[i-1];
//            deb(arr1[i-1],'-',i,j);
            i--;
            continue;
        }
        if(j>0 && dp[i][j]==gap_value+dp[i][j-1])
        {
            ans+=arr2[j-1];
            ans+='-';
//            deb('-',arr2[j-1],i,j);
            j--;
            continue;
        }
        if(i>0 && j>0 && arr1[i-1]==arr2[j-1] && dp[i][j]==match_value+dp[i-1][j-1])
        {
            ans+=arr2[j-1];
            ans+=arr1[i-1];
//            deb(arr1[i-1],arr2[j-1],i,j);
            i--;
            j--;
            continue;
        }
        if(i>0 && j>0 && arr1[i-1]!=arr2[j-1] && dp[i][j]==mis_match_value+dp[i-1][j-1])
        {
//            deb('-','-',i,j);
            ans+='-';
            ans+='-';
            i--;
            j--;
            continue;
        }
    }
    reverse(all(ans));
}



int main ()
{
    cffi;
    fop;
    int i,j,test,n,t=1,pos,nimu;
    string ref_gen;
    cin>>ref_gen;
    fclose(stdin);
    fop2;
    int c=1;
    while(cin>>pos>>nimu>>arr2)
    {
        arr1=ref_gen.substr(pos,nimu);
        ms(dp,-1);
        solve();
        clr(ans);
        solve2();
        deb(c++,sz(arr2),ans);
        cout<<endl<<endl;
    }
    return 0;
}












