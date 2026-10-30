INSERT INTO tb_product (name, date, description, price, img_url) VALUES ('Smartphone XYZ', '2026-10-30T10:00:00Z', 'Smartphone de última geração com 128GB.', 1500.00, 'https://exemplo.com/imagens/smartphone.png');
INSERT INTO tb_product (name, date, description, price, img_url) VALUES ('Fone de Ouvido Bluetooth', '2026-10-29T15:30:00Z', 'Fone sem fio com cancelamento de ruído.', 299.99, 'https://exemplo.com/imagens/fone.png');

INSERT INTO tb_category (name) VALUES ('Eletrônicos');
INSERT INTO tb_category (name) VALUES ('Livros');
INSERT INTO tb_category (name) VALUES ('Roupas e Acessórios');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
