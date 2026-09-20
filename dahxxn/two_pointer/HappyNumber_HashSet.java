class Solution {
    public boolean isHappy(int n) {
        Set<Integer> number = new HashSet<>(); 

        while(n != 1){
            if(number.contains(n)) return false; 

            number.add(n); 
            n = calculate(n); 
        }

        return true; 
    }

    public int calculate(int n){
        int result = 0; 

        while(n > 0){
            result += (n % 10) * (n % 10); //자릿수 제곱을 더함 
            n /= 10; 
        }

        return result; 
    }
}
