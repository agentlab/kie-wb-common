/*
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.workbench.common.widgets.client.datamodel;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.datamodel.oracle.Annotation;
import org.drools.workbench.models.datamodel.oracle.DropDownData;
import org.drools.workbench.models.datamodel.oracle.FieldAccessorsAndMutators;
import org.drools.workbench.models.datamodel.oracle.MethodInfo;
import org.drools.workbench.models.datamodel.oracle.ModelField;
import org.drools.workbench.models.datamodel.oracle.TypeSource;
import org.drools.workbench.models.datamodel.rule.DSLSentence;
import org.kie.workbench.common.widgets.client.callbacks.Callback;
import org.uberfire.backend.vfs.Path;

public interface AsyncPackageDataModelOracle {

    // ####################################
    // Initialise
    // ####################################

    void init( final Path resourcePath );

    // ####################################
    // Editor functions
    // ####################################

    //Package methods
    List<String> getPackageNames();

    //Rule names methods - for "extends" use
    Map<String, Collection<String>> getRuleNamesMap();

    List<String> getRuleNames();

    Collection<String> getRuleNamesForPackage( String packageName );

    //Fact related methods
    String[] getFactTypes();

    String[] getAllFactTypes();

    String[] getExternalFactTypes();

    String getFactNameFromType( final String classType );

    boolean isFactTypeRecognized( final String factType );

    boolean isFactTypeAnEvent( final String factType );

    TypeSource getTypeSource( final String factType );

    String getSuperType( final String factType );

    Set<Annotation> getTypeAnnotations( final String factType );

    Map<String, Set<Annotation>> getTypeFieldsAnnotations( final String factType );

    //Field related methods
    void getFieldCompletions( final String factType,
                              final Callback<ModelField[]> callback );

    void getFieldCompletions( final String factType,
                              final FieldAccessorsAndMutators accessor,
                              final Callback<ModelField[]> callback );

    String getFieldType( final String variableClass,
                         final String fieldName );

    String getFieldClassName( final String factName,
                              final String fieldName );

    String getParametricFieldType( final String factType,
                                   final String fieldName );

    String[] getOperatorCompletions( final String factType,
                                     final String fieldName );

    String[] getConnectiveOperatorCompletions( final String factType,
                                               final String fieldName );

    List<String> getMethodNames( final String factType );

    List<String> getMethodNames( final String factName,
                                 final int i );

    List<String> getMethodParams( final String factType,
                                  final String methodNameWithParams );

    MethodInfo getMethodInfo( final String factName,
                              final String methodName );

    // Global Variable related methods
    String[] getGlobalVariables();

    String getGlobalVariable( final String variable );

    boolean isGlobalVariable( final String variable );

    ModelField[] getFieldCompletionsForGlobalVariable( final String variable );

    List<MethodInfo> getMethodInfosForGlobalVariable( final String variable );

    String[] getGlobalCollections();

    // DSL related methods
    List<DSLSentence> getDSLConditions();

    List<DSLSentence> getDSLActions();

    // Enumeration related methods
    DropDownData getEnums( final String type,
                           final String field );

    DropDownData getEnums( final String factType,
                           final String factField,
                           final Map<String, String> currentValueMap );

    String[] getEnumValues( final String factType,
                            final String factField );

    boolean hasEnums( final String factType,
                      final String factField );

    boolean hasEnums( final String qualifiedFactField );

    boolean isDependentEnum( final String factType,
                             final String factField,
                             final String field );

    //Import related methods
    void filter( final Imports imports );

    void filter();

    // ####################################
    // Population of DMO
    // ####################################

    void setProjectName( final String projectName );

    void setPackageName( final String packageName );

    void addModelFields( final Map<String, ModelField[]> modelFields );

    void addRuleNames( final Map<String, Collection<String>> ruleNames );

    void addFieldParametersType( final Map<String, String> fieldParametersType );

    void addEventTypes( final Map<String, Boolean> eventTypes );

    void addTypeSources( final Map<String, TypeSource> typeSources );

    void addSuperTypes( final Map<String, String> superTypes );

    void addTypeAnnotations( final Map<String, Set<Annotation>> annotations );

    void addTypeFieldsAnnotations( final Map<String, Map<String, Set<Annotation>>> typeFieldsAnnotations );

    void addJavaEnumDefinitions( final Map<String, String[]> dataEnumLists );

    void addMethodInformation( final Map<String, List<MethodInfo>> methodInformation );

    void addCollectionTypes( final Map<String, Boolean> collectionTypes );

    void addPackageNames( final List<String> packageNames );

    void addWorkbenchEnumDefinitions( final Map<String, String[]> dataEnumLists );

    void addDslConditionSentences( final List<DSLSentence> dslConditionSentences );

    void addDslActionSentences( final List<DSLSentence> dslActionSentences );

    void addGlobals( final Map<String, String> packageGlobalTypes );

}