package ejemplo;

import java.util.ArrayList;
import java.util.Iterator;

public class colegio {
    private int codcole;
    private String nomcole;
    private int codciudad;
        private static ArrayList<colegio> listaColegios;

    public colegio(int codcole, String nomcole, int codciudad, ArrayList<colegio> listaColegios) {
        this.codcole = codcole;
        this.nomcole = nomcole;
        this.codciudad = codciudad;
        this.listaColegios = listaColegios;
    }

    public int getCodcole() {
        return codcole;
    }

    public void setNomcole(String nomcole) {
        this.nomcole = nomcole;
    }

    public void setCodciudad(int codciudad) {
        this.codciudad = codciudad;
    }

    public static boolean addNewEjemplo(colegio c) {
            if (findEjemploByClave(c.getCodcole()) == null) {
                listaColegios.add(c);
                return true;
            }
            System.out.println("Error: Ya existe un colegio con el mismo código.");
            return false;
        }

        public static boolean removeEjemplo(int codcole) {
            Iterator<colegio> iterator = listaColegios.iterator();
            while (iterator.hasNext()) {
                colegio c = iterator.next();
                if (c.getCodcole() == codcole) {
                    iterator.remove();
                    return true;
                }
            }
            System.out.println("Error: No se encontró un colegio con ese código.");
            return false;
        }

        public static boolean updateEjemplo(int codcole, String nomcole, int codciudad) {
            colegio c = findEjemploByClave(codcole);
            if (c != null) {
                c.setNomcole(nomcole);
                c.setCodciudad(codciudad);
                return true;
            }
            System.out.println("Error: No se encontró un colegio con ese código.");
            return false;
        }

        public static colegio findEjemploByClave(int codcole) {
            for (colegio c : listaColegios) {
                if (c.getCodcole() == codcole) {
                    return c;
                }
            }
            return null;
        }

        public ArrayList<colegio> queryEjemplo() {
            return listaColegios;
        }

        public static void printEjemplo() {
            if (listaColegios.isEmpty()) {
                System.out.println("No hay colegios registrados.");
            } else {
                for (colegio c : listaColegios) {
                    System.out.println(c);
                }
            }
        }
    }


