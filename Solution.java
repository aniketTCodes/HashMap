
import java.util.*;



public class Solution {

    public static int maxFrequencyNumber(int[] arr){ 
		LinkedHashMap<Integer,Integer> frequency=new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++){
            if(frequency.containsKey(arr[i])){
                frequency.put(arr[i], frequency.get(arr[i])+1);
            }else
            frequency.put(arr[i],1) ;
        }
        int max=Integer.MIN_VALUE;
        int ans=-1;

      Set<Integer> keys=frequency.keySet();
     
      for(Integer key : keys ){
          if(frequency.get(key)>max){
              max=frequency.get(key);
              ans=key;
          }
      }
        return ans;
    }


    public static void printIntersection(int[] arr1,int[] arr2){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */

       
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i : arr2){
            hmap.put(i, hmap.getOrDefault(i, 0)+1);
        }

        for(int i : arr1){
            if(hmap.containsKey(i)&&hmap.get(i)>0){
                System.out.println(i);
                hmap.put(i, hmap.get(i)-1);
            }
        }



	}


    public static int PairSum(int[] input, int size) {
		int count =0 ;
        HashMap<Integer, Integer> hmap=new HashMap<>();
        for(int i : input ){
            if(hmap.containsKey(0-i)){
            count+=hmap.get(0-i);
            }
            hmap.put(i,hmap.getOrDefault(i, 0)+1);
        }
        return count;

	}


   public static String uniqueChar(String str){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        LinkedHashMap<Character,Integer> hmap=new LinkedHashMap<>();
        char charArr[]=str.toCharArray();
        for(char ch : charArr)
       hmap.put(ch, hmap.getOrDefault(ch, 0)+1);

         Set<Character> key=hmap.keySet();
        String result="";
         for(char ch : key)
         result+=ch;
     return result;

	}

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : arr){
            hmap.put(i, 0);
        }

        for(int i: arr){
            if(!hmap.containsKey(i))
            continue;
            int consecutive=i+1;
            while(hmap.containsKey(consecutive)){
                
                hmap.put(i,hmap.get(i)+1);
                consecutive++;
            }
        }
        int max=0;
        int resk=0;
        ArrayList<Integer> result =new ArrayList<>();

        Set<Integer> key=hmap.keySet();
        for(int k : key){
            if(hmap.get(k)>max){
                max=hmap.get(k);
                resk=k;

            }


        }
        result.add(resk);
        result.add(resk+hmap.get(resk));

        return result;



        
        
    }

    public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i : arr){
            hmap.put(i,hmap.getOrDefault(i, 0)+1);
            
        }

        int count=0;
        for(int i :arr){
            int p2 ;
            if(i>=k)
            p2=i-k;
            else
            p2=k+i;
            if(hmap.containsKey(p2)&&hmap.get(p2)>0){
                hmap.put(p2, hmap.get(p2)-1);
                hmap.put(i,hmap.get(i)-1);
                count++;
                
            }
        }
        return count;
    	}


        public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
            // Write your code here
            LinkedHashMap<Integer,Integer> hmap=new LinkedHashMap<>();
            hmap.put(0,-1);
            int sum=0;
           
            int max=Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                
                sum+=arr[i];
                if(hmap.containsKey(sum)){
                    if(i-hmap.get(sum)>max)
                    max=i-hmap.get(sum);
                }
                else
                hmap.put(sum, i);
                

            }
            return max;
        }

   

   
    
}
