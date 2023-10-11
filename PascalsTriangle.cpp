#include <iostream>

int fact(int start, int end){
    if(end == 0 || end == 1){
        return 1;
    }
    if(start == end){
        return 1;
    }
    int factorial = 1;
    for(int i = start+1; i<=end; i++){
        factorial *= i;
    }
    return factorial;
}

int main() {
    int n;
    std::cin >> n;
    
    for(int i = 0; i<n; i++){
        for(int j = 0; j<=i; j++){
            int nCr = fact(j, i)/fact(1, i-j);
            std::cout << nCr <<" ";
        }
        std::cout << std::endl;
    }
    
    return 0;
}
