class Solution {
    public int maximumSaleItems(int [][] items, int budget) {
        int n = items.length;
        int [] freq = new int[n+1];
        int minCost = Integer.MAX_VALUE;
        for(int[] item : items) {
            freq[item [0]]++;
            minCost = Math.min(minCost , item[1]);
        }
        int[] freeCount = new int [n + 1];

        for(int i = 1; i<n; i++){
            if(freq[i] == 0) continue;

            int count = 0;
         for(int j =i ; j<=n; j+=i) {
            count += freq[j];

         }

         freeCount[i] = count-1;
        }
        Arrays.sort(items,(a,b)->a[1]-b[1]);
        int ans = 0;
        int remain = budget;
        for(int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if(price > 2 * minCost) continue;

            int capacity = freeCount[factor];

            int buy = Math.min(capacity , remain/price);

            ans += 2 * buy;

            remain -= buy * price;
        }
        ans += remain/minCost;
        return ans;

    }
}