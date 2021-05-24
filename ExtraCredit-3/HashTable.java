
  /*
      This file defines a HashTable class.  Keys and values in the hash table
      are of type Object.  Keys cannot be null.  The default constructor
      creates a table that initially has 64 locations, but a different
      initial size can be specified as a parameter to the constructor.
  */

public class HashTable {

	public static void main(String[] args) {

		/*
		 * An example to create a hashtable and print its contents
		 */
		HashTable example = new HashTable();

		example.put(200251, "Kate");
		example.put(200277, "Peter");
		example.put(200239, "Roger");

		example.print();
		
		example.remove(200277); // Remove Peter from hash table
		
		example.print();

	}

	static private class ListNode {
		// A ListNode
		// holds a (key,value) pair.
		// Separate Chaining: Nodes that have the same hash code or that are mapped to the same location in the hash table will be linked together as a linked list in the table
		// This private nested class is used
		// internally to implement linked lists.
		Object key;
		Object value;
		ListNode next; // Pointer to next node in the list;
						// A null marks the end of the list.
	}

	private ListNode[] table; // The hash table, represented as
								// an array of linked lists.

	private int count; // The number of (key,value) pairs in the
						// hash table.

	public HashTable() {
		// Create a hash table with an initial size of 64.
		table = new ListNode[64];
	}

	public HashTable(int initialSize) {
		// Create a hash table with a specified initial size.
		// Precondition: initalSize > 0.
		table = new ListNode[initialSize];
	}

	void print() {
		// This lists the (key,value)
		// pairs in each location of the table.
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			// Print out the location number and the list of
			// key/value pairs in this location.
			System.out.print(i + ":");
			ListNode list = table[i]; // For traversing linked list number i.
			while (list != null) {
				System.out.print("  (" + list.key + "," + list.value + ")");
				list = list.next;
			}
			System.out.println();
		}
	} // end dump()

	public void put(Object key, Object value) {
		// Insert a new node with the specified value with the specified key into the hash table
		// Separate Chaining: Nodes that have the same hash code or that are mapped to the same location in the hash table will be linked together as a linked list in the table.
		// Complete the put function.
		int bucket = hash(key); 

		ListNode list = table[bucket];
		while (list != null) {

			if (list.key.equals(key))
				break;
			list = list.next;
		}

		if (list != null) {
			list.value = value;
		}

		else {
			ListNode newNode = new ListNode();
			newNode.key = key;
			newNode.value = value;
			newNode.next = table[bucket];
			table[bucket] = newNode;
			count++;
		}
	}

	public Object get(Object key) {
		// Retrieve the value associated with the specified key
		// in the table, if there is any. If not, the value
		// null will be returned.
		int bucket = hash(key); // At what location of hash table should the key be?
		ListNode list = table[bucket]; // Read the linked list at the corresponding location
		while (list != null) {
			// Check if the specified key is in the current node that
			// list points to. If so, return the associated value. If not, move on to the next node.
			if (list.key.equals(key))
				return list.value;
			list = list.next; // Move on to next node in the list.
		}
		// If we get to this point, then we have looked at every
		// node in the list without finding the key. Return
		// the value null to indicate that the key is not in the table.
		return null;
	}

	public void remove(Object key) {
		// Remove the node with the specified key from the table,
		// if the key occurs in the table. If it does not occur,
		// then nothing is done.
		// Complete the remove function.
		int bucket = hash(key);

		if (table[bucket] == null) {
			return; 
		}

		if (table[bucket].key.equals(key)) {

			table[bucket] = table[bucket].next;
			count--;
			return;
		}

		ListNode prev = table[bucket]; 
		ListNode curr = prev.next;
		while (curr != null && ! curr.key.equals(key)) {
			curr = curr.next;
			prev = curr;
		} 
	}

	public boolean containsKey(Object key) {
		// Test whether the specified key has an associated value
		// in the table.
		int bucket = hash(key); // In what location should key be?
		ListNode list = table[bucket]; // For traversing the list.
		while (list != null) {
			// If we find the key in this node, return true.
			if (list.key.equals(key))
				return true;
			list = list.next;
		}
		// If we get to this point, we know that the key does
		// not exist in the table.
		return false;
	}

	public int size() {
		// Return the number of key/value pairs in the table.
		return count;
	}

	private int hash(Object key) {
		// Compute a hash code for the key; key cannot be null.
		// The hash code depends on the size of the table as
		// well as on the value returned by key.hashCode().
		return (Math.abs(key.hashCode())) % table.length;
	}

	
} // end class HashTable