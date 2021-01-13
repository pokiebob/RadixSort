public class Radix {

	public static int nth(int n, int col) {
		String number = "" + n;
		return Character.getNumericValue(number.charAt(number.length() - col - 1));
	}

	public static int length(int n) {
		String number = "" + Math.abs(n);
		return number.length();
	}

	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
        for(int i = 0; i < buckets.length; ++i) {
            original.extend(buckets[i]);
        }
    }

    public static void radixSortSimple(SortableLinkedList data) {
        SortableLinkedList[] buckets = new SortableLinkedList[10];
        for(int i = 0; i < buckets.length; ++i) {
            buckets[i] = new SortableLinkedList();
        }
        
        int d = 1;
        for(int i = 0; i < d; ++i) {
            while(data.size() > 0) {
                int element = data.remove(0);
                if(i == 0) d = Math.max(d, length(element));
                buckets[nth(element, i)].add(element);
            }
            merge(data, buckets);
        }
        
    }

    public static void radixSort(SortableLinkedList data) {
        SortableLinkedList p = new SortableLinkedList();
        SortableLinkedList n = new SortableLinkedList();

        while(data.size() > 0) {
            int first = data.remove(0);
            if(first >= 0) {
                p.add(first);
            } else {
                n.add(first);
            }
        }

        radixSortSimple(p);
        radixSortSimple(n);
        while(n.size() > 0) {
            data.add(n.remove(n.size() - 1));
        }
        data.extend(p);
    }MyLinkedList[] buckets) {}

	public static void main(String[] args) {
		System.out.println(nth(123, 1));
		System.out.println(nth(-123, 1));
		System.out.println(nth(123, 2));
		System.out.println(nth(123, 2));

		System.out.println(length(0));
		System.out.println(length(15));
		System.out.println(length(-10));
		System.out.println(length(5112));
	}

}