package com.company;

import java.time.LocalDate;

public class Client  extends Persoana implements Comparable<Client>{

        private int nrAsigurare;


        public int getNrAsigurare() {
            return nrAsigurare;
        }

        public Client(String nume, String prenume, LocalDate data_nastere, int nrAsigurare) {
            super(nume, prenume, data_nastere);
            this.nrAsigurare = nrAsigurare;
        }

        @Override
        public boolean equals(Object c) {
            if (this == c) return true;
            if (c == null || getClass() != c.getClass()) return false;
            return super.equals(c)&&getNrAsigurare()==((Client)c).getNrAsigurare();
        }

        @Override
        public String toString() {
            return super.toString()+" "+nrAsigurare;
        }

        @Override
        public int compareTo(Client client) {
            for (int i = 0; i < Math.min(client.getNume().length(), this.getNume().length()); i++) {
                if(this.getNume().charAt(i)!=client.getNume().charAt(i)){
                    return (int)this.getNume().charAt(i)-(int)client.getNume().charAt(i);
                }
            }
            if(this.getNume().length()!=client.getNume().length())
                return this.getNume().length()-client.getNume().length();
            else
                return 0;

        }
    }
