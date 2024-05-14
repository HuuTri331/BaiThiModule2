import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    private List<Patient> patients;
    private final String FILE_NAME = "patient.txt";

    public Hospital() {
        this.patients = new ArrayList<>();
    }

    public void addPatientFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mã BA: ");
        String idBA = scanner.nextLine();
        System.out.print("Nhập mã BN: ");
        String idBN = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày vào viện: ");
        int dayin = scanner.nextInt();
        System.out.print("Nhập ngày ra viện: ");
        int dayout = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên bệnh nhân: ");
        String namepatient = scanner.nextLine();
        System.out.print("Nhập chức vụ: ");
        String role = scanner.nextLine();

        Patient patient = new Patient(id, idBA, idBN, name, dayout, dayin, namepatient, role);
        patients.add(patient);

        System.out.println("Bệnh nhân đã được thêm vào danh sách.");
    }

    public void removePatient(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                patients.remove(patient);
                System.out.println("Bệnh nhân có ID " + id + " đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân có ID " + id + " trong danh sách.");
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách bệnh nhân trống.");
            return;
        }
        System.out.println("Danh sách bệnh nhân:");
        for (Patient patient : patients) {
            System.out.println("ID: " + patient.getId());
            System.out.print("; Mã BA: " + patient.getIdBA());
            System.out.print("; Mã BN: " + patient.getIdBN());
            System.out.print("; Tên: " + patient.getName());
            System.out.print("; Ngày vào viện: " + patient.getDayin());
            System.out.print("; Ngày ra viện: " + patient.getDayout());
            System.out.print("; Tên bệnh nhân: " + patient.getNamepatient());
            System.out.println("; Chức vụ: " + patient.getRole());
            System.out.println("--------------------");
        }
    }

    public void savePatientsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Patient patient : patients) {
                writer.println(patient.getId() + "," + patient.getIdBA() + "," + patient.getIdBN() + "," +
                        patient.getName() + "," + patient.getDayin() + "," + patient.getDayout() + "," +
                        patient.getNamepatient() + "," + patient.getRole());
            }
            System.out.println("Dữ liệu bệnh nhân đã được lưu vào file " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể ghi vào file " + FILE_NAME);
        }
    }

    public void loadPatientsFromFile() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            patients.clear();
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                String idBA = data[1];
                String idBN = data[2];
                String name = data[3];
                int dayin = Integer.parseInt(data[4]);
                int dayout = Integer.parseInt(data[5]);
                String namepatient = data[6];
                String role = data[7];

                Patient patient = new Patient(id, idBA, idBN, name, dayout, dayin, namepatient, role);
                patients.add(patient);
            }
            System.out.println("Dữ liệu bệnh nhân đã được đọc từ file " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: Không tìm thấy file " + FILE_NAME);
        }
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.loadPatientsFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("--Chương trình quản lý bệnh án--");
            System.out.println("Chọn chức năng (để tiếp tục):");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Xóa bệnh nhân");
            System.out.println("3. Hiển thị danh sách bệnh nhân");
            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hospital.addPatientFromInput();
                    hospital.savePatientsToFile();
                    break;
                case 2:
                    System.out.print("Nhập ID bệnh nhân cần xóa: ");
                    int idToRemove = scanner.nextInt();
                    hospital.removePatient(idToRemove);
                    hospital.savePatientsToFile();
                    break;
                case 3:
                    hospital.loadPatientsFromFile();
                    hospital.displayPatients();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);

        scanner.close();
    }
}
