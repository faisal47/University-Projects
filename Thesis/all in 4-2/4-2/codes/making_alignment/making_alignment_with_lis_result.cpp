
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

int k_mer_size=11;
int cnt;
string ref_text;
vec_<pii>v;
string tex1,tex2;
string arr1,arr2;
vec_<pair<string,string>>arr;

bool col1[1010];
bool col2[1010];
int matches,penalty;
int dp[1010][1010];
int match_score=1;
int penalty_score=0;

int solve(int i,int j)
{
    if(i>=sz(arr1) || j>=sz(arr2))
        return 0;
    int &ret=dp[i][j];
    if(ret != -1)
        return ret;
    ret=0;
    if(arr1[i]==arr2[j])
        ret=max(ret,match_score+solve(i+1,j+1));
    ret=max(ret,penalty_score+solve(i+1,j));
    ret=max(ret,penalty_score+solve(i,j+1));
    ret=max(ret,penalty_score+solve(i+1,j+1));

    return ret;
}

void solve2(int i,int j)
{
    if(i>=sz(arr1) || j>=sz(arr2))
        {
            if(i>=sz(arr1))
                penalty+=(sz(arr2)-j);
            else
                penalty+=(sz(arr1)-i);
            return;
        }
    int &ret=dp[i][j];
    ret=0;
    if(ret==match_score+solve(i+1,j+1))
    {
        matches++;
        solve2(i,j);
        return;
    }
    penalty++;
    if(ret== penalty_score+solve(i+1,j+1))
    solve2(i+1,j+1);
    else if(ret == penalty_score+solve(i+1,j))
    solve2(i+1,j);
    else
    solve2(i,j+1);

    return;
}



void go2()
{
    ms(dp,-1);
    solve(0,0);
    solve2(0,0);
}

void go()
{
    ms(col1,0);
    ms(col2,0);
    repa(b,v)
    {
        for(int i=b.fs;i<b.fs+k_mer_size;i++)
            col1[i]=1;
        for(int i=b.sc;i<b.sc+k_mer_size;i++)
            col2[i]=1;
    }
    int m;
    int ma,mb;
    ma=mb=0;
    rep(i,sz(arr1))
    if(col1[i])
        ma++;
    rep(i,sz(arr2))
    if(col2[i])
        mb++;

    m=max(ma,mb);
    matches=m*2;
    deb(sz(arr2));
    penalty=0;
    string temp1,temp2;
    temp1=temp2="";

    rep(i,sz(arr1))
    if(!col1[i])
    temp1+=arr1[i];

    rep(i,sz(arr2))
    if(!col2[i])
    temp2+=arr2[i];
    arr1=temp1;
    arr2=temp2;
    /// ekhon go2() te gie arr1 ar arr2 er lcs ber kore matches ar penalty ber korte hobe
    go2();
    deb(matches,penalty);
}

int main ()
{
     ifstream in1("reference.txt"), in2("sam_to_normal_read.txt"), in3("Lis_result.txt");
//    int n;
//    in1 >> n;
//    cout << n << endl;
//    in2 >> n;
//    cout << n << endl;
//    in3 >> n;
//    cout << n << endl;
//    freopen("reference.txt","r",stdin);
    in1>>ref_text;
//    fclose(stdin);
//    deb(ref_text);

//    freopen("sam_to_normal_read.txt","r",stdin);
    freopen("values.txt","w",stdout);

    cnt=0;
    int i,j,sp,n,a,b;

    while(in2>>sp>>arr2)
    {
        arr1=ref_text.substr(sp-1,sz(arr2));
        arr.pb({arr1,arr2});
    }
//    fclose(stdin);
//    freopen("Lis_result.txt","r",stdin);
    cnt=0;
//    n=0;
//    i>>n;
//    deb(n);
    while(in3>>n)
    {
//        deb("yo");
        clr(v);
        rep(i,n)
        {
            in3>>a>>b;
            v.pb({a,b});
        }
        arr1=arr[cnt].fs;
        arr2=arr[cnt].sc;
        cnt++;
        /// v te arr1 ar arr2 er lis pos gula ache oigulake mix up korte hobe ar majher gula die blockwise n*n chalaite hobe
        go();
    }
//    fclose(stdin);
    return 0;
}









