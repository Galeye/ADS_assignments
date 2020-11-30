class solutionTest{
	public static void main(String[] args) {
		Solution<String, Integer> tree = new Solution<String, Integer>();
		tree.put("ABDUL",1);
		tree.get("ABDUL");
		tree.put("HRITIK",2);
		tree.put("SAI",3);
		tree.put("SAMAL",6);
		tree.get("SAI");
		tree.put("TASHI",4);
		System.out.println(tree.size());
		tree.min();
		System.out.println(tree.floor("HRITIK"));
		System.out.println(tree.floor("HAHA"));
		//assert(tree.floor("HAHA")=="HRITIK");
		assert(tree.isEmpty()==false);
		System.out.println(tree.select(2));
		System.out.println(tree.keys("ABDUL","TASHI"));
		tree.put("CHIMI",5);
		tree.put("SAMAL",4);
		tree.get("SAMAL");
		tree.put("NIMA",7);
		System.out.println(tree.size());
		tree.get("CHIMI");
		System.out.println(tree.floor("CHIMA"));
		tree.put("SONAM",8);		
		tree.keys("ABDUL","TASHI");
		System.out.println(tree.keys("ABDUL","TASHI"));
	}
}