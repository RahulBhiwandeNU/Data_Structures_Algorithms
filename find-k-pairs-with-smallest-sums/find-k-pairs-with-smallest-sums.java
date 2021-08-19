class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;

		List<List<Integer>> kSmallestPairs = new ArrayList<>();

        // No pairing possible when n1/n2/k == 0
		if (n1 == 0 || n2 == 0 || k == 0) {
			return kSmallestPairs;
		}

        // Sort by sum of nums1[i], nums2[j]
		PriorityQueue<int[]> smallestSumPairs = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Add min(n1, k) pairs to the heap where each element in nums1 array pairs up with 0th index in nums2 array initially!
        // Note that index 2 of each pair is the sum of nums1[i], nums2[0] which is used to heapify & thereby pick k smallest pairs
		for (int i = 0; i < Math.min(n1, k); i++) {
			smallestSumPairs.add(new int[] { nums1[i], 0, nums1[i] + nums2[0] });
		}

		while (!smallestSumPairs.isEmpty() && k-- > 0) {
			int[] currentPair = smallestSumPairs.poll();

			kSmallestPairs.add(Arrays.asList(currentPair[0], nums2[currentPair[1]]));

            // If currentPair[1] (aka 'j' referring to nums2 array) is within bounds? - Add 1 to the current index 'j' to get the next number in nums2 array
			if (currentPair[1] < n2 - 1) {
				smallestSumPairs.add(new int[] { currentPair[0], currentPair[1] + 1, currentPair[0] + nums2[currentPair[1] + 1] });
			}
		}

		return kSmallestPairs;
    }
}