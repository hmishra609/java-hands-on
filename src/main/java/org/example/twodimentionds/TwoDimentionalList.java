package org.example.twodimentionds;

import java.util.ArrayList;
import java.util.List;

public class TwoDimentionalList {
    static void main() {
        ArrayList<ArrayList<Integer>> twodlist = new ArrayList<>();

        twodlist.add(new ArrayList<>(List.of(1, 2, 3)));
        twodlist.add(new ArrayList<>(List.of(4, 5, 6)));
        twodlist.add(new ArrayList<>(List.of(7, 8, 9)));


        for(int i=0; i< twodlist.size();i++){
            ArrayList<Integer> row = twodlist.get(i);
            for(int j=0; j< row.size();j++){
                System.out.print(row.get(j));
            }
            System.out.println();
        }


    }


}
