
public class StringPermutation {
	
	String swap(String a,int l, int r){
		char tmp;
		char ar[] =  a.toCharArray();
		tmp = ar[l];
		ar[l]=ar[r];
		ar[r]=tmp;
		return String.valueOf(ar);
	}
	
	public static void main(String []args)
	{
		StringPermutation sp = new StringPermutation();
		sp.permute("ABC", 0, 2);
	}
	
	void permute(String str,int l,int r){
		
		if(l==r){
			System.out.println(str);
		}
		for (int i = l; i <= r; i++) {
		
		str = swap(str,l,i);
		permute(str,l+1,r);
		str = swap(str,l,i);
		}
	}

}
          
