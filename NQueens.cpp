#include <iostream>

using namespace std;

int queen[20];

int column[20], diagonal1[40], diagonal2[40];

void nQueen(int at, int n){
    if(at == n+1){
        printf("(row, column) = ");
        for(int i = 1; i<=n; i++){
            printf("(%d, %d) ", i, queen[i]);
        }
        printf("\n");
        return;
    }
    for(int i= 1; i<=n; i++){
        if(column[i] || diagonal1[i + at] || diagonal2[n+i-at])
            continue;
        queen[at] = i;
        
        column[i] = diagonal1[i+at] = diagonal2[n+i-at] = 1;
        
        nQueen(at+1, n);
        column[i] = diagonal1[i + at] = diagonal2[n+i-at] = 0;
    }
}

int main(){
    nQueen(1, 8);
    
    return 0;
}
