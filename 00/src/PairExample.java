/*interface Pair<K, V> {
	public K getKey();
	public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {
	private K key;
	private V value;
	
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
}

	public K getKey(){ return key; }
	public V getValue() { return value; }

}
class Box<T> {
	private T t;
	public T get() { return t; }
	public void set(T t) { this.t = t; }
}

public class PairExample {
	public static void main(String[] args) {
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
		System.out.println(p1);
		Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");
		System.out.println(p2);
		OrderedPair<String, Integer> p3 = new OrderedPair<>("Even", 8);
		System.out.println(p3);
		OrderedPair<String, String> p4 = new OrderedPair<>("hello", "world");
		System.out.println(p4);
		OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());
		System.out.println(p);
	}
}
*/
