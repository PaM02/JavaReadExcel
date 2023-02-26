package xcl;

import java.io.File;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Xcel {

    public static void main(String[] args) {

        try {
            File file = new File("C:/Users/papa matar/Desktop/donnees_compteur.xlsx"); // creating a new file instance
            // creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();

            boolean isHeader = true;
            int i = 1;
            while (itr.hasNext()) {
                Row row = itr.next();
                // System.out.println("my i "+i);
                MeterDataModel meterData = new MeterDataModel();
                if (isHeader) {
                    isHeader = false;
                    i++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // System.out.print("Column index "+cell.getColumnIndex());
                    /*
                     * ici c'est pour remplir l'objet meterData
                     */
                    if (cell.getColumnIndex() == 0) { // insert id client
                        /* il test ici si la cellule est vide */
                        meterData.setIdClient(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 1) { // insert id client
                        /* il test ici si la cellule est vide */
                        meterData.setIdCompteur(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 2) { // insert id client
                        /* il test ici si la cellule est vide */
                        meterData.setIdPointComptage(cell.getStringCellValue());
                    }

                    i++;
                }

                System.out.println(meterData.getIdClient());

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}