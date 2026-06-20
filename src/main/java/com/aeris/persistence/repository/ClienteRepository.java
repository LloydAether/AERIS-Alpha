package com.aeris.persistence.repository;

import com.aeris.core.SessionManager;
import com.aeris.domain.Cliente;
import com.aeris.persistence.connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public List<Cliente> listar() {

        List<Cliente> lista = new ArrayList<>();

        String sql = """
                SELECT
                    c.id_cliente,
                    c.codigo,
                    td.codigo tipo_documento,
                    c.numero_documento,
                    c.nombre_razon_social,
                    c.telefono,
                    c.direccion,
                    c.estado::text
                FROM aeris.cliente c
                INNER JOIN aeris.tipo_documento td
                    ON td.id_tipo_documento=c.id_tipo_documento
                WHERE c.id_empresa=?
                ORDER BY c.nombre_razon_social
                """;

        try(Connection cn=DatabaseConnection.getConnection();
            PreparedStatement ps=cn.prepareStatement(sql)){

            ps.setInt(1, SessionManager.getEmpresaId());

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                lista.add(new Cliente(

                        rs.getInt("id_cliente"),
                        rs.getString("codigo"),
                        rs.getString("tipo_documento"),
                        rs.getString("numero_documento"),
                        rs.getString("nombre_razon_social"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("estado")

                ));

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

    public List<Cliente> buscar(String texto){

        List<Cliente> lista=new ArrayList<>();

        String sql="""
                SELECT
                    c.id_cliente,
                    c.codigo,
                    td.codigo tipo_documento,
                    c.numero_documento,
                    c.nombre_razon_social,
                    c.telefono,
                    c.direccion,
                    c.estado::text
                FROM aeris.cliente c
                INNER JOIN aeris.tipo_documento td
                    ON td.id_tipo_documento=c.id_tipo_documento
                WHERE
                    c.id_empresa=?
                AND
                (
                    UPPER(c.nombre_razon_social) LIKE UPPER(?)
                    OR
                    UPPER(c.numero_documento) LIKE UPPER(?)
                    OR
                    UPPER(c.codigo) LIKE UPPER(?)
                )
                ORDER BY c.nombre_razon_social
                """;

        try(Connection cn=DatabaseConnection.getConnection();
            PreparedStatement ps=cn.prepareStatement(sql)){

            ps.setInt(1,SessionManager.getEmpresaId());

            String filtro="%"+texto+"%";

            ps.setString(2,filtro);
            ps.setString(3,filtro);
            ps.setString(4,filtro);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                lista.add(new Cliente(

                        rs.getInt("id_cliente"),
                        rs.getString("codigo"),
                        rs.getString("tipo_documento"),
                        rs.getString("numero_documento"),
                        rs.getString("nombre_razon_social"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getString("estado")

                ));

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

}