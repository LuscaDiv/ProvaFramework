// create database lucasho;

// use lucasho;

// CREATE TABLE paciente (
//     id INT PRIMARY KEY AUTO_INCREMENT,
//     nome VARCHAR(255) NOT NULL,
//     cpf VARCHAR(255) NOT NULL,
//     idade INT NOT NULL
// );

// CREATE TABLE medico (
//     id INT PRIMARY KEY AUTO_INCREMENT,
//     nome VARCHAR(255) NOT NULL,
//     especialidade INT NOT NULL,
//     crm INT NOT NULL,
//     cpf VARCHAR(255) NOT NULL
// );

// CREATE TABLE consulta (
//     convenio VARCHAR(255) NOT NULL,
//     id INT PRIMARY KEY AUTO_INCREMENT,
//     idmedico INT NOT NULL,
//     idpaciente INT NOT NULL,
//     FOREIGN KEY (idmedico)
//         REFERENCES medico (id)
//         ON DELETE CASCADE ON UPDATE CASCADE,
//     FOREIGN KEY (idpaciente)
//         REFERENCES paciente (id)
//         ON DELETE CASCADE ON UPDATE CASCADE
// );