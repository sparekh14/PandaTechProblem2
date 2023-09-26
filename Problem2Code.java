class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        // created an ArrayList of the numbers to be able to easily manipulate the ordering of the numbers
        ArrayList<Integer> numsCopy = new ArrayList<>();
        for (int num : nums) {
            numsCopy.add(num);
        }

        // variable to keep track of the number of operations
        long operations = 0;

        // keeps the loop going while it is not empty
        while(numsCopy.size() != 0) {
            // utilizes a helper method to check whether or not the first number is the smallest or not
            if (isSmallest(numsCopy)) {
                numsCopy.remove(numsCopy.get(0));
                operations++;
            }
            // if the first number is not the smallest, then it moves the first number to the end
            else {
                Integer firstNum = numsCopy.get(0);
                numsCopy.remove(0);
                numsCopy.add(firstNum);
                operations++;
            }
        }

        return operations;
    }

    // helper method written to check whether or not the first number is the smallest or not
    public boolean isSmallest(ArrayList<Integer> nums) {
        int smallest = nums.get(0);
        for (int num = 1; num < nums.size(); num++) {
            if (nums.get(num) < smallest) {
                return false;
            }
        }
        return true;
    }
}
