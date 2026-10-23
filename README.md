# Character Manager — TP3 & TP5
Mata Kuliah: Java Visual (SIH-6406)

**Nama:** Luther Jecky Natanael Malau  
**NIM:** 263316621261

## Deskripsi

Character Manager adalah project Java yang dikembangkan secara bertahap untuk mempraktikkan class, object, constructor, encapsulation, enum, object reference, dan pengelolaan kumpulan objek.

Pada TP3, project mencakup atribut karakter, validasi mana, `isAlive()`, dan level up. Pada TP5, project dikembangkan dengan fitur pengelolaan karakter menggunakan `CharacterManager`.

## Fitur TP3

- Empat tipe karakter menggunakan enum
- Constructor, getter, dan setter
- Validasi nilai mana agar tidak negatif
- `isAlive()` untuk memeriksa kondisi karakter
- Level up yang meningkatkan hit points dan attack
- `toString()` untuk menampilkan informasi karakter

## Fitur TP5

- `addCharacter()` untuk menambah karakter dan menolak nama duplikat
- `findByName()` untuk mencari karakter berdasarkan nama
- `removeCharacter()` untuk menghapus karakter
- `getTotalCharacters()` untuk menghitung jumlah karakter
- `getAllCharacters()` untuk memberikan salinan daftar karakter
- `getAverageLevel()` untuk menghitung rata-rata level, termasuk saat daftar kosong
- `findByType()` untuk mencari karakter berdasarkan tipe
- `findStrongest()` sebagai fitur tambahan untuk mencari karakter dengan attack tertinggi
- `equals()` untuk membandingkan karakter berdasarkan nama
- Eksperimen object reference dan static counter

## Screenshot TP3

![Character Manager Output](screenshots/character-manager-output.png)
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

Dokumen analisis object reference, primitive vs reference, static counter, equals(), dan defensive copy:

[Document Analysis TP5](https://docs.google.com/document/d/1laqV9ykuvLZrTRzMNo4mBxcClv7DFGbQ91m7KJjdqmo/edit?usp=sharing)

## Struktur Folder

```text
CharacterManager/
├── src/
│   └── com/unpri/charactermanager/
│       ├── CharacterManager.java
│       ├── Main.java
│       └── model/
│           ├── Character.java
│           └── CharacterType.java
├── screenshots/
├── README.md
└── .gitignore
```
