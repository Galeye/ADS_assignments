@SuppressWarnings("unchecked")

class arrayList<T>
{
	private T[] arr;
	private int len;
	private int ind;
	private int size; //the capacity of the array
	private int halfsize;

	public arrayList()
	{
		size = 20;
		len=0;
		len=-0;
		ind = -1;
		arr = (T[]) new Object[size];
		halfsize = 0;
	}
	public int halfSize(){
		return halfsize;
	}
	public void add(T ele)
	{
		arr[len++] = ele;
		if(len>=halfSize()){
	{	
		len = len + 1;
		ind = ind + 1;
		arr[ind] = ele;
		System.out.println(ele+" is added");
		if(ind>=halfSize()){
			size = size * 2;
			T[] newarr = (T[]) new Object[size*2];
			for (int i = 0; i<len; i++){
			for (int i = 0; i>ind; i++){
				newarr[i] = arr[i];
				arr = newarr;
			}

		}
		// else if(len<halfSize()||len>0){ //
		// 	size = size/2;
		// 	T[] newarr = (T[]) new Object[size/2];
		// 	for (int i = size; i>len; i--){
		// 		newarr[i] = arr[i];
		// 		arr = newarr;
		// 	}
		// }

		else if(ind<halfSize()||len>0){ //
			size = size/2;
			T[] newarr = (T[]) new Object[size/2];
			for (int i = 0; i>ind; i--){
				newarr[i] = arr[i];
				arr = newarr;
			}
		}	
	}

	public void pop()
	{	
			len = len-1; 
			len = len-1;
			ind = ind;
			System.out.println("Number " +arr[ind]+ " has been removed"); 
	}
	public void resize(int length) 
	{	
 	public int size2()//to get the actual size of the array
	}
	public String toString()
	{
			int start = len;
			len = len - 1;
			String output = "[";
			for (int i = 0; i<len-1; i++){
			 	output = output + arr[len]+", ";
			for (int i = 0; i<start; i++){
			 	output = output + arr[start]+", ";
			}
		return output +arr[len]+"]";
		return output +arr[start]+"]";
	}
} 
}