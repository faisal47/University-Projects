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
#define fop freopen("start_mhcic50.txt","r",stdin);freopen("cluster_output.txt","w",stdout);
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

int dur(int x1,int y1,int x2,int y2)
{
    return ((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}

#define mt
#define mod
int k=3,n;

pii arr[550];
vec_<vec_<pii>>v,temp;
vec_<pii>centers;

bool check()
{
    int i;
    rep(i,k)
    {
        sort(all(temp[i]));
        sort(all(v[i]));
    }
    rep(i,k)
    if(temp[i] != v[i])
        return 0;
    return 1;
}

void push_em()
{
    int i;
    rep(i,k)
    v[i]=temp[i];
}


void go2()
{
    int i,dis,j;
    rep(i,k)
    clr(temp[i]);
    rep(i,n)
    {
        dis=inf;
        rep(j,k)
        dis=min(dis,dur(arr[i].fs,arr[i].sc,centers[j].fs,centers[j].sc));
        rep(j,k)
        if(dis == dur(arr[i].fs,arr[i].sc,centers[j].fs,centers[j].sc))
        {
            temp[j].pb(arr[i]);
            break;
        }
    }
}

void make_centers()
{
    vec_<pii>temp2;
    clr(centers);
    int i,j,mini=inf,maxi;
    rep(i,k)
    {
        mini=inf;
        temp2=v[i];
        repa(b1,temp2)
        {
            maxi=0;
            repa(b2,temp2)
            maxi=max(maxi,dur(b1.fs,b1.sc,b2.fs,b2.sc));
            mini=min(mini,maxi);
        }
        repa(b1,temp2)
        {
            maxi=0;
            repa(b2,temp2)
            maxi=max(maxi,dur(b1.fs,b1.sc,b2.fs,b2.sc));
            if(mini == maxi)
            {
                centers.pb(b1);
                break;
            }
        }
    }
}

void go()
{
    v.resize(k);
    temp.resize(k);
    int i;
    rep(i,k)
    centers.pb(arr[i]);
    while(1)
    {
        go2();
        if(check())
            break;
        push_em();
        make_centers();
    }
}

int main ()
{
    cffi;
    fop;
    int i,j,test,t=1,a,b;
    while(cin>>a>>b)
    {
        arr[n]={a,b};
        n++;
    }
    go();
    rep(i,k)
    {
        deb(sz(v[i]));
        repa(num,v[i])
        deb(num.fs,num.sc);
    }
    return 0;
}










