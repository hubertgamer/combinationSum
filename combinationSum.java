import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        List<Integer> currSol = new ArrayList<Integer>();
        helper(sol, currSol, 0, candidates, target);
        return sol;
    }
    public void helper(List<List<Integer>> sol, List<Integer> currSol, int currIndex, int[] candidates, int target) {
    	if (target == 0) {
    		sol.add(new ArrayList<Integer>(currSol));
    		return;
    	}
    	if (target < 0 || currIndex >= candidates.length) {
    		return;
    	}
    	currSol.add(candidates[currIndex]);
    	helper(sol, currSol, currIndex, candidates, target - candidates[currIndex]);
    	currSol.remove(currSol.size()-1);
    	helper(sol, currSol, currIndex + 1, candidates, target);
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.combinationSum(new int[]{2,3,6,7}, 7));
    	System.out.println(s.combinationSum(new int[]{2,3,5}, 8));	
    }
}