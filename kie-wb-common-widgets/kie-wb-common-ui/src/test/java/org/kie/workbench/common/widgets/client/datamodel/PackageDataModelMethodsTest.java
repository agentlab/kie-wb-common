/*
* Copyright 2010 JBoss Inc
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.kie.workbench.common.widgets.client.datamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.drools.workbench.models.datamodel.oracle.FieldAccessorsAndMutators;
import org.drools.workbench.models.datamodel.oracle.MethodInfo;
import org.drools.workbench.models.datamodel.oracle.ModelField;
import org.drools.workbench.models.datamodel.oracle.PackageDataModelOracle;
import org.drools.workbench.models.datamodel.oracle.ProjectDataModelOracle;
import org.jboss.errai.common.client.api.Caller;
import org.junit.Test;
import org.kie.workbench.common.services.datamodel.backend.server.builder.packages.PackageDataModelOracleBuilder;
import org.kie.workbench.common.services.datamodel.backend.server.builder.projects.ProjectDataModelOracleBuilder;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;
import org.kie.workbench.common.services.datamodel.service.IncrementalDataModelService;
import org.uberfire.backend.vfs.Path;
import org.uberfire.client.callbacks.Callback;

import static org.junit.Assert.*;
import static org.kie.workbench.common.widgets.client.datamodel.PackageDataModelOracleTestUtils.assertContains;
import static org.mockito.Mockito.*;

public class PackageDataModelMethodsTest {

    @Test
    public void testMethodsOnJavaClass_TreeMap() throws Exception {
        final ProjectDataModelOracle projectLoader = ProjectDataModelOracleBuilder.newProjectOracleBuilder()
                .addClass( TreeMap.class )
                .build();

        final PackageDataModelOracle packageLoader = PackageDataModelOracleBuilder.newPackageOracleBuilder( "java.util" ).setProjectOracle( projectLoader ).build();

        //Emulate server-to-client conversions
        final MockAsyncPackageDataModelOracleImpl oracle = new MockAsyncPackageDataModelOracleImpl();
        final Caller<IncrementalDataModelService> service = new MockIncrementalDataModelServiceCaller();
        oracle.setService( service );

        final PackageDataModelOracleBaselinePayload dataModel = new PackageDataModelOracleBaselinePayload();
        dataModel.setPackageName( packageLoader.getPackageName() );
        dataModel.setModelFields( packageLoader.getProjectModelFields() );
        dataModel.setMethodInformation( packageLoader.getProjectMethodInformation() );
        PackageDataModelOracleTestUtils.populateDataModelOracle( mock( Path.class ),
                                                                 new MockHasImports(),
                                                                 oracle,
                                                                 dataModel );

        oracle.getFieldCompletions( TreeMap.class.getSimpleName(),
                                    FieldAccessorsAndMutators.ACCESSOR,
                                    new Callback<ModelField[]>() {
                                        @Override
                                        public void callback( final ModelField[] getters ) {
                                            assertEquals( 2,
                                                          getters.length );
                                            assertEquals( "this",
                                                          getters[ 0 ].getName() );
                                            assertEquals( "empty",
                                                          getters[ 1 ].getName() );
                                        }
                                    } );

        oracle.getMethodInfos( TreeMap.class.getSimpleName(),
                               new Callback<List<MethodInfo>>() {
                                   @Override
                                   public void callback( final List<MethodInfo> mis ) {
                                       assertEquals( 33,
                                                     mis.size() );
                                       assertContains( "ceilingEntry",
                                                       mis );
                                       assertContains( "ceilingKey",
                                                       mis );
                                       assertContains( "clear",
                                                       mis );
                                       assertContains( "clone",
                                                       mis );
                                       assertContains( "comparator",
                                                       mis );
                                       assertContains( "containsKey",
                                                       mis );
                                       assertContains( "containsValue",
                                                       mis );
                                       assertContains( "descendingKeySet",
                                                       mis );
                                       assertContains( "descendingMap",
                                                       mis );
                                       assertContains( "firstEntry",
                                                       mis );
                                       assertContains( "firstKey",
                                                       mis );
                                       assertContains( "floorEntry",
                                                       mis );
                                       assertContains( "floorKey",
                                                       mis );
                                       assertContains( "get",
                                                       mis );
                                       assertContains( "headMap",
                                                       mis );
                                       assertContains( "headMap",
                                                       mis );
                                       assertContains( "higherEntry",
                                                       mis );
                                       assertContains( "higherKey",
                                                       mis );
                                       assertContains( "lastEntry",
                                                       mis );
                                       assertContains( "lastKey",
                                                       mis );
                                       assertContains( "lowerEntry",
                                                       mis );
                                       assertContains( "lowerKey",
                                                       mis );
                                       assertContains( "navigableKeySet",
                                                       mis );
                                       assertContains( "pollFirstEntry",
                                                       mis );
                                       assertContains( "pollLastEntry",
                                                       mis );
                                       assertContains( "put",
                                                       mis );
                                       assertContains( "remove",
                                                       mis );
                                       assertContains( "size",
                                                       mis );
                                       assertContains( "subMap",
                                                       mis );
                                       assertContains( "subMap",
                                                       mis );
                                       assertContains( "tailMap",
                                                       mis );
                                       assertContains( "tailMap",
                                                       mis );
                                       assertContains( "values",
                                                       mis );
                                   }
                               } );

        oracle.getFieldCompletions( TreeMap.class.getSimpleName(),
                                    FieldAccessorsAndMutators.MUTATOR,
                                    new Callback<ModelField[]>() {
                                        @Override
                                        public void callback( final ModelField[] setters ) {
                                            assertEquals( 0,
                                                          setters.length );
                                        }
                                    } );
    }

    @Test
    public void testMethodsOnJavaClass_ArrayList() throws Exception {
        final ProjectDataModelOracle projectLoader = ProjectDataModelOracleBuilder.newProjectOracleBuilder()
                .addClass( ArrayList.class )
                .build();

        final PackageDataModelOracle packageLoader = PackageDataModelOracleBuilder.newPackageOracleBuilder( "java.util" ).setProjectOracle( projectLoader ).build();

        //Emulate server-to-client conversions
        final MockAsyncPackageDataModelOracleImpl oracle = new MockAsyncPackageDataModelOracleImpl();
        final Caller<IncrementalDataModelService> service = new MockIncrementalDataModelServiceCaller();
        oracle.setService( service );

        final PackageDataModelOracleBaselinePayload dataModel = new PackageDataModelOracleBaselinePayload();
        dataModel.setPackageName( packageLoader.getPackageName() );
        dataModel.setModelFields( packageLoader.getProjectModelFields() );
        dataModel.setMethodInformation( packageLoader.getProjectMethodInformation() );
        PackageDataModelOracleTestUtils.populateDataModelOracle( mock( Path.class ),
                                                                 new MockHasImports(),
                                                                 oracle,
                                                                 dataModel );

        oracle.getMethodInfos( ArrayList.class.getSimpleName(),
                               new Callback<List<MethodInfo>>() {
                                   @Override
                                   public void callback( final List<MethodInfo> methodInfos ) {
                                       assertNotNull( methodInfos );
                                       assertFalse( methodInfos.isEmpty() );
                                       for ( final MethodInfo methodInfo : methodInfos ) {
                                           assertFalse( "Method " + methodInfo.getName() + " is not allowed.",
                                                        checkBlackList( methodInfo.getName() ) );
                                       }
                                   }
                               } );
    }

    private boolean checkBlackList( String methodName ) {
        return ( "hashCode".equals( methodName )
                || "equals".equals( methodName )
                || "addAll".equals( methodName )
                || "containsAll".equals( methodName )
                || "iterator".equals( methodName )
                || "removeAll".equals( methodName )
                || "retainAll".equals( methodName )
                || "toArray".equals( methodName )
                || "listIterator".equals( methodName )
                || "subList".equals( methodName )
                || "entrySet".equals( methodName )
                || "keySet".equals( methodName )
                || "putAll".equals( methodName ) );
    }

}
