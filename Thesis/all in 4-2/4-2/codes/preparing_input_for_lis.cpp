
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
#define rep(i,n) for(int i=0;i<n;i++)
#define rep1(i,n) for(int i=1;i<=n;i++)
#define repa(i,n) for(auto i: n)
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


#define mt 1000010
#define mod

int k_mer_size=15;
int cnt;
string ref_text;
string arr1,arr2;
int thres_hold=3;
vec_<pii>v;
string tex1,tex2;

void go2(int a,int b)
{
    if(sz(tex1) != sz(tex2))
        return;
    int mn=0;
    rep(i,sz(tex1))
    if(tex1[i]!=tex2[i])
        mn++;
    if(mn<=thres_hold)
    v.pb({a,b});
}

void go()
{
    rep(i,sz(arr1)-k_mer_size+1)
    {
        tex1=arr1.substr(i,k_mer_size);
        rep(j,sz(arr2)-k_mer_size+1)
        {
            tex2=arr2.substr(j,k_mer_size);
            go2(i,j);
        }
    }
    deb(sz(v));
    repa(it,v)
    deb(it.fs,it.sc);
}

int main ()
{
    freopen("reference.txt","r",stdin);

    freopen("output2.txt","w",stdout);
    cin>>ref_text;
    deb(ref_text);
    fclose(stdout);
    fclose(stdin);

    freopen("sam_to_normal_read.txt","r",stdin);
    freopen("input_for_LIS.txt","w",stdout);

    cnt=0;
    int i,j,sp,n,t=1;

    while(cin>>sp>>arr2)
    {
        arr1=ref_text.substr(sp-1,sz(arr2));
        clr(v);
        go();
        cnt++;
    }

//    deb(cnt);


    return 0;
}









