insert into cozinha (id, nome_cozinha) values (1, 'Tailandesa');
insert into cozinha (id, nome_cozinha) values (2, 'Indiana');

insert into estado (id, nome_estado) values (1, 'Paraná');
insert into estado (id, nome_estado) values (2, 'São Paulo');

insert into cidade(id, nome_cidade, estado_id) values (1, 'Curitiba', 1);
insert into cidade(id, nome_cidade, estado_id) values (2, 'Sorocaba', 2);

insert into restaurante (id, nome_restaurante, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id, nome_restaurante, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome_restaurante, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp);

insert into forma_pagamento (id, descricao_forma_pagamento) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao_forma_pagamento) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao_forma_pagamento) values (3, 'Dinheiros');

insert into permissao (id, nome_permissao, descricao_permissao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome_permissao, descricao_permissao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);