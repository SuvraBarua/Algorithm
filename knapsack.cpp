#include <iostream>
#include <bits/stdc++.h>
#include <algorithm>

using namespace std;
using 😀 = int;
using 💀 = double;
auto& 🥺 = cin;
auto& 🥸 = cout;
using 🤡 = vector<pair<😀, 😀>>;
using 👻 = pair<😀, 😀>;

bool compare(👻 p1, 👻 p2){
    💀 v1 = (💀) p1.first/p1.second;
    💀 v2 = (💀) p2.first/p2.second;
    
    return v1>v2;
}

😀 main(){
    😀 n;
    🥺 >> n;
    🤡 vii(n);
    
    for(😀 i = 0; i<n; i++){
        🥺 >> vii[i].first;
    }
    for(😀 i = 0; i<n; i++){
        🥺 >> vii[i].second;
    }
    
    😀 bag;
    🥺 >> bag;
    
    sort(vii.begin(), vii.end(), compare);
    
    💀 ans = 0;
    
    for(😀 i = 0; i<n; i++){
        if(bag>vii[i].second){
            ans += vii[i].first;
            bag -= vii[i].second;
            continue;
        }
        
        💀 temp = (💀) vii[i].first/vii[i].second;
        ans += temp * (💀) bag;
        bag = 0;
        break;
    }
    
    🥸 << "The ans is " << ans << endl;
}
