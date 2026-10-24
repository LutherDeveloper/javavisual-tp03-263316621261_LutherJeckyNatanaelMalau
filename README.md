# Character Manager — TP3 & TP5 & TP8
Mata Kuliah: Java Visual

**Nama:** Luther Jecky Natanael Malau  
**NIM:** 263316621261

## Screenshot TP3

![Character Manager Output](screenshots/character-manager-output.png)

## Analisis Google Docs

[Document Analysis TP3](https://docs.google.com/document/d/1E0JfsgATnNYDeVj7zkCt0OgDjtFt66PZzHQIvI_jKow/edit?usp=sharing)

## Screenshot TP5

### 1. CRUD dan Penolakan Duplikat
![CRUD dan penolakan duplikat](screenshots/01-crud-duplicate.png)

### 2. Analytics dan Find Strongest
![Analytics](screenshots/02-analytics.png)

### 3. Object Reference
![Eksperimen object reference](screenshots/03-object-reference.png)

### 4. Defensive Copy
![Eksperimen defensive copy](screenshots/04-defensive-copy.png)

## Analisis Google Docs

[Document Analysis TP5](https://docs.google.com/document/d/1laqV9ykuvLZrTRzMNo4mBxcClv7DFGbQ91m7KJjdqmo/edit?usp=sharing)


## TP8 — Character Manager Sprint #3: MainWindow, Data Dinamis & Analisis MVC

### Implementasi
TP8 mengembangkan Character Manager dari program berbasis console menjadi aplikasi GUI menggunakan Java Swing. Tampilan utama dibuat dalam kelas `MainWindow` yang mewarisi `JFrame`. Data karakter diambil melalui `CharacterManager` dan ditampilkan secara dinamis menggunakan perulangan, sehingga daftar tidak perlu ditulis satu per satu secara manual.

Aplikasi menampilkan enam karakter: Arthur, Merlin, Robin, Morrigan, Lyra, dan Darius. Statistik rata-rata level dihitung menggunakan `CharacterManager.getAverageLevel()` dan ditampilkan melalui `JLabel`. Tombol **Naikkan Level Lyra (+1)** digunakan untuk mengubah level Lyra dan memperbarui daftar serta statistik pada tampilan.

### Bukti Screenshot

**Sebelum perubahan — rata-rata level 5.50**

![TP8 sebelum perubahan](screenshots/tp8-before.png)

**Sesudah perubahan — rata-rata level 5.67**

![TP8 sesudah perubahan](screenshots/tp8-after.png)

## Analisis Google Docs

[Document Analysis TP8](https://docs.google.com/document/d/1YuUuwlcIKhMpSbZ3j4L91MaFQ3YWwNlvuurS1qPc3D0/edit?usp=sharing)

### Data Flow dan MVC
Alur aplikasi dimulai dari `Main`, yang membuat objek `CharacterManager` dan mengisi data karakter. `CharacterManager` mengelola koleksi karakter serta menyediakan operasi pencarian dan perhitungan rata-rata level. Objek `MainWindow` menerima `CharacterManager`, mengambil data karakter, kemudian menampilkan daftar dan statistik melalui komponen Swing. Pemisahan ini memisahkan pengelolaan data dari tampilan, meskipun penanganan tombol pada implementasi ini masih berada di kelas View dan dapat dipisahkan lebih lanjut ke Controller untuk penerapan MVC yang lebih ketat.

### Karakter Baru
- **Lyra** — ARCHER, level 3. Karakter ini ditambahkan untuk menguji perubahan level dan pembaruan statistik secara langsung.
- **Darius** — WARRIOR, level 7. Karakter ini menambah variasi level dan tipe karakter untuk menguji tampilan data dinamis.

