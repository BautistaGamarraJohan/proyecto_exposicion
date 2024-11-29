package main;

import CSVReader.CSVReader;

public class MainCsv {
    public static void main(String[] args) {
    CSVReader lector = new CSVReader();
    // Asegúrate que esta ruta coincida EXACTAMENTE con la ubicación de tu archivo
    lector.leerCSV("F:\\exposicionlunes\\Proyecto\\vacuna\\vacunas_covid.csv");
    }
}