/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

/**
 *
 * @author Reza
 */
//Start of the program
import java.util.Scanner;

public class Calculator {    
    public static void main(String arg[]) {            
        Scanner input = new Scanner(System.in);
        Scanner input_2 = new Scanner(System.in);
        int pilihan = 0; float[]angka  = new float[20];  int i = 0; char[] operasi = new char[19]; float hasil = 0; char pilihan_2;
        while(pilihan != 6){            
            //Masukkan angka            
            System.out.print("Masukkan angka : "); angka[i] = input.nextInt();            
            System.out.flush();
            
            System.out.print("\n" + "input anda : ");
            for (int awal = 0; awal <= i; awal++){
                System.out.print(" " + angka[awal] + " " + operasi[awal]);                    
                if (awal == i){
                    awal = 0;
                    break;
                }
            }                
            System.out.println("\n");         
            //Masukkan pilihan Yang Diinginkan
            System.out.print("1. Tambah (+) ");
            System.out.print("2. Kurang (-) ");
            System.out.print("3. Kali (x) ");
            System.out.print("4. Bagi (÷) ");
            System.out.print("5. Hasil (=) ");
            System.out.println("6. Keluar ");
            System.out.print("Masukkan pilihan : ");
            pilihan = input.nextInt();                               
            switch(pilihan){
                case 1:
                operasi[i] = '+';
                break;
                case 2:
                operasi[i] = '-';
                break;
                case 3:
                operasi[i] = 'x';
                break;
                case 4:
                operasi[i] = '÷';
                break;
                case 5:
                for (int check = 0; check <= i; check++){
                    if (operasi[check] == '÷'){
                        angka[check] = angka[check]/angka[check+1];
                        angka[check+1] = 0;
                        if (operasi[check+1] == 'x' || operasi[check+1] == '÷'){
                            angka[check+1] = angka[check];
                            angka[check] = 0;
                            operasi[check] = '+';
                        }
                        else{
                            operasi[check] = '+';
                        }
                    }
                    if (operasi[check] == 'x'){
                        angka[check] = angka[check] * angka[check+1];
                        angka[check+1] = 0;
                        if (operasi[check+1] == 'x' || operasi[check+1] == '÷'){
                            angka[check+1] = angka[check];
                            angka[check] = 0;
                            operasi[check] = '+';
                        }
                        else{
                            operasi[check] = '+';
                        }                    
                    }                                        
                }
                for (int check = 0; check <= i; check++){
                    if(operasi[check] == '+'){
                        hasil = angka[check] + angka[check+1];
                        angka[check] = 0;
                        angka[check+1] = hasil;
                    }
                    if(operasi[check] == '-'){
                        hasil = angka[check] - angka[check+1];
                        angka[check] = 0;
                        angka[check+1] = hasil;
                    }
                    if(check == i){                  
                        System.out.println("hasil = " + angka[check]);
                        for(int clear = 0; clear <= i; clear++){
                            angka[clear] = 0;
                            operasi[clear] = 0;
                        }                                                   
                        while(true){
                            System.out.print("lanjut? (y/n) : ");    
                            pilihan_2 = input_2.next().charAt(0); 
                            if(pilihan_2 == 'n'){
                                pilihan = 6;
                                break;
                            }
                            if(pilihan_2 == 'y'){
                                System.out.print("Memulai Program Kembali\n");
                                i = -1;
                                break;
                            }
                            else{
                                System.out.println("Pilihan invalid coba lagi");
                            }
                        }                                        
                    }
                }
                break;
                case 6:                
                break;
                default:
                System.out.println("Pilihan invalid coba lagi");
            }            
            System.out.flush();                        
            i += 1;            
        }
        System.out.println("Terima kasih sudah menggunakan program ini ");
    }            
}
