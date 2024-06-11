CREATE TABLE tarea (
	id INT PRIMARY KEY AUTO_INCREMENT,
	titulo VARCHAR(100) NOT NULL,
	descripcion VARCHAR(200),
	fecha_creacion DATE DEFAULT CURRENT_DATE,
	fecha_vencimiento DATE,
	estado ENUM('PENDIENTE', 'EN_PROGRESO', 'COMPLETADA') DEFAULT 'PENDIENTE'
);

INSERT INTO tarea ( titulo, descripcion, fecha_vencimiento, estado) VALUES
	('Hacer la presentación', 'Preparar diapositivas para la reunión', '2024-03-10', 'EN_PROGRESO'),
	('Comprar víveres', 'Lista de compras para la semana', '2024-03-08', 'PENDIENTE'),
	('Enviar informe mensual', 'Resumen de ventas y métricas', '2024-03-15', 'PENDIENTE'),
	('Hacer la presentación', 'Preparar diapositivas para la reunión', '2024-03-10', 'EN_PROGRESO');