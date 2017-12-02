
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
#define make_flush  cout << flush; //    fflush(stdout);
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
#define repa(i,n) for(auto i: n)
#define fop freopen("input.txt","r",stdin);freopen("input_for_clustering2(with name).txt","w",stdout);
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

#define mt
#define mod


string arr[300];
int nums[300][3];

bool ovs(int a,int b,int c,int d)
{
//    int a=nums[i][0];
//    int b=nums[i][1];
//    int c=nums[j][0];
//    int d=nums[j][1];
    while(a<=b && c<=d)
    {
        if(a==c)
            return 1;
        if(a<c)
            a++;
        else
            c++;
    }
    return 0;
}

void go(int c,int d,int i)
{
    int mini=inf,j;
    map<string,bool>ma;
    rep(j,i)
    if(ovs(nums[j][0],nums[j][0]+8,c,d))
    {
        mini=min(mini,nums[j][2]);
        ma[arr[j]]=1;
    }
    if(mini >=inf)
        mini=0;
    deb(c,mini,sz(ma));
    repa(name,ma)
    deb(name.fs);
}

void go2(int c,int d,int i)
{
    int mini=inf,j;
    map<string,bool>ma;
    rep(j,i+1)
    if(ovs(nums[j][0],nums[j][0]+8,c,d))
    {
        mini=min(mini,nums[j][2]);
        ma[arr[j]]=1;
    }
    if(mini >=inf)
        mini=0;
    deb(c,mini,sz(ma));
    repa(name,ma)
    deb(name.fs);

}


int main ()
{
    cffi;
    fop;
    int i,j,test,n,t=1;
    n=0;
    while(cin>>arr[n])
    {
        cin>>nums[n][0];
        cin>>nums[n][1];
        cin>>nums[n][2];
        n++;
    }
    int pres,pree;
    pres=1;
    rep(i,n)
    {
        int snow=nums[i][0];
        for(int k=pres+1; k<snow; k++)
            go(k,k+8,i);
        if(snow <= pres)
            snow=pres+1;
        go2(snow,snow+8,i);
        pres=snow;
    }
    return 0;
}










