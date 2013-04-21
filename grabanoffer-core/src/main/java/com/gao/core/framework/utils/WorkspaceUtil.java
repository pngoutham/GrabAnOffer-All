/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gao.core.framework.utils;

/**
 *
 * @author goutham_PN
 */
/**
 * A utility class for workspace tags and its default values used while creating workspace.
 */
public class WorkspaceUtil {

    public static final String WORKSPACE_FILES_LOCATION = "com.netexcompany.kubbe.multitenant.repository.workspace.ws";
    public static final String WORKSPACE_CONFIGURATION_FILE_EXTENSION=".xml";

    public static class WORKSPACE_NAME {        
        public static final String LOCAL_FILESYSTEM_PATH = "path";
        public static final String SEARCH_INDEX_PATH = "path";
        public static final String SEARCH_INDEX_SUPPORTHIGHLIGHTING = "supportHighlighting";
        public static final String PERSISTNECE_MANAGER_BUNDLECACHESIZE = "bundleCacheSize";
        public static final String PERSISTNECE_MANAGER_CONSISTENCYCHECK = "consistencyCheck";
        public static final String PERSISTNECE_MANAGER_MINBLOBSIZE = "minBlobSize";
        public static final String PERSISTNECE_MANAGER_DRIVER_INITIALCONTEXT = "driver";
        public static final String PERSISTNECE_MANAGER_DRIVER = "driver";
        public static final String PERSISTNECE_MANAGER_URL = "url";
        public static final String PERSISTNECE_MANAGER_USER = "user";
        public static final String PERSISTNECE_MANAGER_PASSWORD = "password";
        public static final String PERSISTNECE_MANAGER_SCHEMA = "schema";
        public static final String PERSISTNECE_MANAGER_SCHEMAOBJECTPREFIX = "schemaObjectPrefix";
        public static final String PERSISTNECE_MANAGER_ERRORHANDLING = "errorHandling";
    }

    public static class WORKSPACE_DEFAULT_VALUES {

        public static final String LOCAL_FILESYSTEM_CLASS_NAME = "org.apache.jackrabbit.core.fs.local.LocalFileSystem";
        public static final String PERSISTNECE_MANAGER_CLASS_NAME = "org.apache.jackrabbit.core.persistence.bundle.MySqlPersistenceManager";
        public static final String SEARCH_INDEX_CLASS_NAME = "org.apache.jackrabbit.core.query.lucene.SearchIndex";
        public static final String LOCAL_FILESYSTEM_PATH = "${wsp.home}";
        public static final String SEARCH_INDEX_PATH = "${wsp.home}/index";
        public static final String SEARCH_INDEX_SUPPORTHIGHLIGHTING = "false";
        public static final String PERSISTNECE_MANAGER_BUNDLECACHESIZE = "8";
        public static final String PERSISTNECE_MANAGER_CONSISTENCYCHECK = "false";
        public static final String PERSISTNECE_MANAGER_MINBLOBSIZE = "16384";
        public static final String PERSISTNECE_MANAGER_DRIVER_INITIALCONTEXT = "javax.naming.InitialContext";
        public static final String PERSISTNECE_MANAGER_DRIVER = "com.mysql.jdbc.Driver";
        public static final String PERSISTNECE_MANAGER_SCHEMA = "mysql";
        public static final String PERSISTNECE_MANAGER_SCHEMAOBJECTPREFIX = "jr_";
        public static final String PERSISTNECE_MANAGER_ERRORHANDLING = "";
    }
}
