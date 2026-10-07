class Solution {
    public int minAddToMakeValid(String s) {
        int require =0;
        int balancer=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                balancer--;
            }
            else{
                balancer++;
            }
            if(balancer<0){
                require++;
                balancer=0;
            }
        }
        require+=balancer;
        return require;
    }
}