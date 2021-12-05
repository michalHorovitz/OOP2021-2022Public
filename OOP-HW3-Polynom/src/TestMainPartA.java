public class TestMainPartA {
	public static void main(String[] args) {
		IPolynom<Complex> poly1 = 
				new Polynom<Complex>();
		poly1.addMonom(2, new ComplexFieldMember(new Complex(0,1)));	
		System.out.println(poly1);
		poly1.addMonom(2, new ComplexFieldMember(new Complex(1,1)));
		System.out.println(poly1);
		poly1.addMonom(5, new ComplexFieldMember(new Complex(-1,0)));
		poly1.addMonom(1, new ComplexFieldMember(new Complex(-3,2)));
		System.out.println(poly1);
		
		IPolynom<Double> poly2 = 
				new Polynom<Double>();
		poly2.addMonom(2, new DoubleFieldMember(2.5));	
		System.out.println(poly2);
		poly2.addMonom(2, new DoubleFieldMember(3.0));	
		System.out.println(poly2);
		poly2.addMonom(5, new DoubleFieldMember(-1.3));
		poly2.addMonom(1, new DoubleFieldMember(-3.89));
		System.out.println(poly2);
		
	}
}
