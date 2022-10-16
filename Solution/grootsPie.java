import java.util.*;

public class grootsPie {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the inputs for the sweetness values of the available pies");
		System.out.println("Input Eg-8,4,3,2,6,5");
		int arr[] = Arrays.stream(sc.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
		
		System.out.println("Enter the desired sweetness");
		int n=sc.nextInt();
		
		int b[]=Arrays.copyOf(arr,arr.length);
		List < List < Integer >> answer = combinationSum2(arr, n);
        
		for(int i=0;i<answer.size();i++) {
			for(int j=0;j<answer.get(i).size();j++){
				{
					System.out.print(linearSearch(b,answer.get(i).get(j))+" ");
				}
			}
			System.out.println();
		}
	}  
	
	public static int linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    }    
	
	static void findCombinations(int ind, int[] arr1, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr1.length; i++) {
            if (i > ind && arr1[i] == arr1[i - 1]) continue;
            if (arr1[i] > target) break;

            ds.add(arr1[i]);
            findCombinations(i + 1, arr1, target - arr1[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public static List < List < Integer >> combinationSum2(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

}
