package neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsFrequency = new HashMap<>();
        for (int num : nums) {
            Integer fCount = numsFrequency.getOrDefault(num, 0);
            numsFrequency.put(num, fCount + 1);
        }
        PriorityQueue<NumFrequency> maxHeap = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> e : numsFrequency.entrySet()) {
            maxHeap.offer(new NumFrequency(e.getKey(), e.getValue()));
        }
        int[] topKFrequent = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequent[i] = maxHeap.poll().num;
        }
        return topKFrequent;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}

class NumFrequency implements Comparable<NumFrequency> {
    int num;
    int frequency;

    public NumFrequency(int num, int frequency) {
        this.num = num;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(NumFrequency that) {
        return that.frequency - this.frequency;
    }
}
