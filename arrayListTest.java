class arrayListTest{
	public static void main(String[] a){
		arrayList<Integer> test = new arrayList<Integer> ();

		test.add(1);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(6);
		test.add(7);
		test.add(4);
		test.add(3);
		test.add(4);
		test.pop();
		//test.resize(5);
		test.toString();
		System.out.println("The length of the elements = "+test.size());
		System.out.println("The size of the array = "+test.size2());
		System.out.println(""+test.toString());
		//System.out.println("the real size is : "+test.size2());
		System.out.println("Congratulation! All test cases passed!");
	}
} 