insert into cozinha (id, nome_cozinha) values (1, 'Tailandesa');
insert into cozinha (id, nome_cozinha) values (2, 'Indiana');

insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

 insert into estado (id, nome_estado) values (1, 'Paraná');
 insert into estado (id, nome_estado) values (2, 'São Paulo');
 
 insert into cidade(id, nome_cidade, estado_id) values (1, 'Curitiba', 1);
 insert into cidade(id, nome_cidade, estado_id) values (2, 'Sorocaba', 2);