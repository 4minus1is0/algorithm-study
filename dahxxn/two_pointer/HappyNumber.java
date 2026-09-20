class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = calculate(n);

        while(slow != fast){
            slow = calculate(slow);
            fast = calculate(calculate(fast));
        }

        return fast == 1;
    }

    private int calculate(int n) {
        int result = 0;

        while (n > 0) {
            int digit = n % 10;
            result += digit * digit;
            n /= 10;
        }

        return result;
    }
}
