// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public Main() {
   }

   static int getBaseToll(String var0) {
      if (var0.equalsIgnoreCase("car")) {
         return 50;
      } else if (var0.equalsIgnoreCase("bike")) {
         return 20;
      } else {
         return var0.equalsIgnoreCase("truck") ? 100 : 0;
      }
   }

   static int getRouteToll(String var0, String var1) {
      if (var0.equalsIgnoreCase("chennai") && var1.equalsIgnoreCase("kadapa")) {
         return 30;
      } else if (var0.equalsIgnoreCase("hyd") && var1.equalsIgnoreCase("mumbai")) {
         return 40;
      } else {
         return var0.equalsIgnoreCase("chennai") && var1.equalsIgnoreCase("bangalore") ? 25 : 10;
      }
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      ArrayList var2 = new ArrayList();
      int var3 = 0;

      while(true) {
         System.out.println("\n1. Add Journey");
         System.out.println("2. Show Report");
         System.out.println("3. Search Vehicle");
         System.out.println("4. Exit");
         int var4 = var1.nextInt();
         if (var4 == 1) {
            System.out.print("Enter vehicle number: ");
            String var16 = var1.next();
            System.out.print("Enter vehicle type (car/bike/truck): ");
            String var18 = var1.next();
            System.out.print("Enter start location: ");
            String var20 = var1.next();
            System.out.print("Enter destination: ");
            String var22 = var1.next();
            int var24 = getBaseToll(var18);
            int var25 = getRouteToll(var20, var22);
            int var26 = var24 + var25;
            System.out.println("Discount Applied: 10%");
            var26 -= var26 * 10 / 100;
            System.out.println("Final Toll: " + var26);
            var3 += var26;
            Vehicle var12 = null;

            for(Vehicle var14 : var2) {
               if (var14.number.equals(var16)) {
                  var12 = var14;
                  break;
               }
            }

            if (var12 == null) {
               var12 = new Vehicle(var16);
               var2.add(var12);
            }

            var12.journeys.add(new Journey(var18, var20, var22, var26));
         } else if (var4 == 2) {
            System.out.println("\n--- FULL REPORT ---");

            for(Vehicle var17 : var2) {
               System.out.println("Vehicle: " + var17.number);
               int var19 = 0;

               for(Journey var23 : var17.journeys) {
                  System.out.println("  " + var23.type + " | " + var23.start + " -> " + var23.destination + " | Toll: " + var23.toll);
                  var19 += var23.toll;
               }

               System.out.println("  Total for vehicle: " + var19);
            }

            System.out.println("Overall Revenue: " + var3);
         } else if (var4 != 3) {
            if (var4 == 4) {
               System.out.println("Exiting...");
               var1.close();
               return;
            }

            System.out.println("Invalid choice");
         } else {
            System.out.print("Enter vehicle number to search: ");
            String var5 = var1.next();
            boolean var6 = false;

            for(Vehicle var8 : var2) {
               if (var8.number.equals(var5)) {
                  System.out.println("Vehicle Found: " + var8.number);
                  int var9 = 0;

                  for(Journey var11 : var8.journeys) {
                     System.out.println(var11.type + " | " + var11.start + " -> " + var11.destination + " | Toll: " + var11.toll);
                     var9 += var11.toll;
                  }

                  System.out.println("Total Paid: " + var9);
                  var6 = true;
               }
            }

            if (!var6) {
               System.out.println("Vehicle not found");
            }
         }
      }
   }
}
