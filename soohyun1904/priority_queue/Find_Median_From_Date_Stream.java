class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
       minHeap = new PriorityQueue<>(Collections.reverseOrder());
       maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); 
        }

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}


// class MedianFinder {
//     List<Integer> numbers;

//     public MedianFinder() {
//         this.numbers = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         numbers.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(numbers);
//         if(numbers.size() % 2 == 0) {
//             return (numbers.get(numbers.size() / 2 - 1) + numbers.get(numbers.size() / 2)) / 2.0;
//         }
//         return numbers.get(numbers.size()/2);
//     }
// }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */