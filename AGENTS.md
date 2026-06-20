# \# AGENTS.md

# 

# \# AERIS Alpha - Reglas del Proyecto

# 

# Este documento define las reglas obligatorias para cualquier asistente de IA (Codex, ChatGPT u otros) y para cualquier desarrollador que trabaje sobre este proyecto.

# 

# Estas reglas tienen prioridad sobre cualquier sugerencia automática.

# 

# \---

# 

# \# Objetivo del proyecto

# 

# AERIS Alpha es un ERP de escritorio desarrollado en Java 21 para empresas dedicadas al alquiler de recursos.

# 

# El objetivo no es únicamente que funcione.

# 

# El objetivo es construir un software mantenible, escalable y profesional.

# 

# \---

# 

# \# Tecnologías oficiales

# 

# Java 21

# 

# Maven

# 

# Swing

# 

# FlatLaf

# 

# MigLayout

# 

# PostgreSQL

# 

# Supabase

# 

# BCrypt

# 

# No introducir nuevas tecnologías sin autorización.

# 

# \---

# 

# \# Arquitectura

# 

# La arquitectura es por capas.

# 

# UI

# 

# ↓

# 

# Service

# 

# ↓

# 

# Repository

# 

# ↓

# 

# Database

# 

# Nunca romper esta arquitectura.

# 

# \---

# 

# \# Organización de paquetes

# 

# config

# 

# core

# 

# domain

# 

# persistence

# 

# service

# 

# security

# 

# ui

# 

# view

# 

# util

# 

# No crear paquetes nuevos sin autorización.

# 

# \---

# 

# \# Reglas obligatorias

# 

# \## Base de datos

# 

# Todo SQL pertenece únicamente a Repository.

# 

# Nunca escribir SQL dentro de:

# 

# \- UI

# \- Service

# \- Domain

# 

# \---

# 

# \## UI

# 

# La UI nunca accede directamente a la base de datos.

# 

# La UI únicamente conversa con Service.

# 

# \---

# 

# \## Service

# 

# Toda lógica de negocio pertenece aquí.

# 

# Validaciones.

# 

# Reglas.

# 

# Procesos.

# 

# Nunca escribir SQL.

# 

# \---

# 

# \## Repository

# 

# Toda consulta SQL.

# 

# INSERT

# 

# UPDATE

# 

# DELETE

# 

# SELECT

# 

# Nada más.

# 

# \---

# 

# \## Domain

# 

# Las entidades representan tablas.

# 

# No contienen lógica de negocio.

# 

# \---

# 

# \## Componentes UI

# 

# Reutilizar siempre los componentes existentes.

# 

# CrudToolbar

# 

# CrudTable

# 

# AerisButton

# 

# AerisHeader

# 

# AerisSidebar

# 

# AerisStatusBar

# 

# AerisTheme

# 

# No duplicar componentes.

# 

# \---

# 

# \# Convenciones

# 

# No modificar nombres de paquetes.

# 

# No renombrar clases existentes.

# 

# No romper compatibilidad.

# 

# Entregar archivos completos.

# 

# No entregar únicamente fragmentos.

# 

# \---

# 

# \# Base de datos

# 

# La aplicación utiliza PostgreSQL sobre Supabase.

# 

# No modificar el esquema sin autorización.

# 

# No eliminar columnas existentes.

# 

# No cambiar nombres de tablas.

# 

# \---

# 

# \# Eliminación

# 

# Nunca eliminar registros físicamente.

# 

# Siempre utilizar eliminación lógica mediante el campo estado.

# 

# \---

# 

# \# Código

# 

# Priorizar código limpio.

# 

# Priorizar reutilización.

# 

# Evitar duplicación.

# 

# Mantener consistencia.

# 

# \---

# 

# \# Antes de modificar archivos

# 

# Analizar primero el proyecto.

# 

# Si un cambio afecta otras capas, preguntar antes.

# 

# Nunca asumir.

# 

# \---

# 

# \# Objetivo final

# 

# Construir un ERP profesional listo para producción.

# 

# Toda decisión debe favorecer:

# 

# Escalabilidad.

# 

# Mantenibilidad.

# 

# Legibilidad.

# 

# Consistencia.

# 

# Rendimiento.

# 

# Seguridad.

