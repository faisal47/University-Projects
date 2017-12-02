
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


//double dur(int x1,int y1,int x2,int y2)
//{
//    return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
//}
//template<class T> string toString(T n){ostringstream oss;oss<<n;oss.flush();return oss.str();}
int toInt(string s)
{
    int r=0;
    istringstream sin(s);
    sin>>r;
    return r;
}


#define mt
#define mod

#define fop freopen("ecoli_double_index_base_result_fourthv.sam","r",stdin);freopen("values(L M MM I D).txt","w",stdout);

string arr2;
string arr[15];
map<char,char>ma;
string pre(string temp)
{
    int i;
    reverse(all(temp));
    ma['A']='T';
    ma['T']='A';
    ma['C']='G';
    ma['G']='C';
    rep(i,sz(temp))
    temp[i]=ma[temp[i]];
    return temp;
}

int pre2(string temp)
{
    int c=0;
    int m,mm,ins,del,num;
    m=mm=ins=del=0;
//    deb(temp);
    while(c<sz(temp))
    {
        num=0;
        while(!isalpha(temp[c]))
        {
            num=(num*10)+(temp[c]-'0');
            c++;
        }
        if(temp[c]=='M')
            m+=num;
        else if(temp[c] == 'X')
            mm+=num;
        else if(temp[c] == 'D')
            del+=num;
        else
            ins+=num;
        c++;
    }
    deb(m,mm,ins,del);
    return m+mm+del+ins-del;
}

int main ()
{
    cffi;
    fop;
    cin>>arr2>>arr2;
    int i,j,test,n,t=1,c=0;
    while(cin>>arr2)
    {
        rep(i,10)
        cin>>arr[i];
        if(sz(arr[9]) <= 1000)
        {
            c++;
            if(toInt(arr[1])!=0)
                arr[9]=pre(arr[9]);
            deb(sz(arr[9]));
            pre2(arr[5]);
        }
        if(c == 1000)
            break;
    }
    return 0;
}











