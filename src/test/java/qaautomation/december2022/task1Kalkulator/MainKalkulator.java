package qaautomation.december2022.task1Kalkulator;

public class MainKalkulator extends MethodKalkulator {
	public static void main(String[] args) throws Exception {
		MethodKalkulator cetak = new MethodKalkulator();
		cetak.setBilangan();
		System.out.println("Hasil tambah sama dengan: "+cetak.getHasilTambah());
		System.out.println("Hasil pengurangan sama dengan: "+cetak.getHasilKurang());
		System.out.println("Hasil pengurangan sama dengan: "+cetak.getHasilKali());
		System.out.println("Hasil pengurangan sama dengan: "+cetak.getHasilBagi());
	}

}
