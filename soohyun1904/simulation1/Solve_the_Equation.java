class Solution {
    public String solveEquation(String equation) {
        List<String> split = splitEquation(equation);
        int[] LHS = calculate(split.get(0));
        int[] RHS = calculate(split.get(1));
        
        int variable = LHS[0]-RHS[0];
        int constant = -LHS[1]+RHS[1];

        if(constant == 0) {
            if(LHS[0] == RHS[0]) {
               return "Infinite solutions";
            }
        }

        if(variable == 0) {
            return "No solution";
        }

        
        StringBuilder sb = new StringBuilder();

        constant /= variable;
        sb.append('x');
        sb.append('=');
        sb.append(constant);
        return sb.toString();
    }

    public List<String> splitEquation(String equation) {
        int location = findEqualSignPosition(equation);
        List<String> expressions = new ArrayList<>();
        String LHS = equation.substring(0, location);
        expressions.add(LHS);
        String RHS = equation.substring(location + 1);
        expressions.add(RHS);
        return expressions;
    }

    public int[] calculate(String expression) {
        int[] result = new int[2]; 
        StringBuilder prev = new StringBuilder();

        for (char ch : expression.toCharArray()) {
            if ((ch == '+' || ch == '-') && prev.length() > 0) {
                applyTerm(prev.toString(), result); 
                prev.setLength(0);                 
            }
            prev.append(ch);                      
        }
        applyTerm(prev.toString(), result);        

        return result;                            
    }

    private void applyTerm(String term, int[] result) { 
        if (term.charAt(term.length() - 1) == 'x') {                 
            String coef = term.substring(0, term.length() - 1);      
        if (coef.equals("") || coef.equals("+")) {             
            result[0] += 1;
        } else if (coef.equals("-")) {                           
            result[0] -= 1;
        } else {                                                
            result[0] += Integer.parseInt(coef);
        }
        } else {
            result[1] += Integer.parseInt(term);                     
        }
    }

    public int findEqualSignPosition(String equation) {
        int location = 0;
        while(equation.charAt(location) != '=') {
            location++;
        }
        return location;
    }
}