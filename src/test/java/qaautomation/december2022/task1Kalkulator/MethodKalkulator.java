package qaautomation.december2022.task1Kalkulator;

import java.util.Scanner;

public class MethodKalkulator {
	public int bilA, bilB;
	public double hasil;
	private Scanner sc;
	
	//public void setBilangan(int a, int b) {
	public void setBilangan() throws Exception {
		try {
			sc = new Scanner(System.in);
			System.out.println("Masukan Bilangan Pertama: ");
			bilA= sc.nextInt();
			System.out.println("Masukan Bilangan Kedua: ");
			bilB = sc.nextInt();
			System.out.println("Kalkulator Penambahan, Pengurangan, Perkalian, dan Pembagian");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error: This is not number");
		}
	}
	
	public double getHasilTambah() {
		hasil = bilA + bilB;
		return hasil;
	}
	
	
	public double getHasilKurang() {
		hasil = bilA - bilB;
		return hasil;
	}
	
	public double getHasilKali() {
		hasil = bilA * bilB;
		return hasil;
	}
	
	public double getHasilBagi() {
		hasil = bilA / bilB;
		return hasil;
	}
	
}
