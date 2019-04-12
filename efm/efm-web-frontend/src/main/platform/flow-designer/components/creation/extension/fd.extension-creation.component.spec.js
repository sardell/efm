/*
 * (c) 2018-2019 Cloudera, Inc. All rights reserved.
 *
 *  This code is provided to you pursuant to your written agreement with Cloudera, which may be the terms of the
 *  Affero General Public License version 3 (AGPLv3), or pursuant to a written agreement with a third party authorized
 *  to distribute this code.  If you do not have a written agreement with Cloudera or with an authorized and
 *  properly licensed third party, you do not have any rights to this code.
 *
 *  If this code is provided to you under the terms of the AGPLv3:
 *   (A) CLOUDERA PROVIDES THIS CODE TO YOU WITHOUT WARRANTIES OF ANY KIND;
 *   (B) CLOUDERA DISCLAIMS ANY AND ALL EXPRESS AND IMPLIED WARRANTIES WITH RESPECT TO THIS CODE, INCLUDING BUT NOT
 *       LIMITED TO IMPLIED WARRANTIES OF TITLE, NON-INFRINGEMENT, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE;
 *   (C) CLOUDERA IS NOT LIABLE TO YOU, AND WILL NOT DEFEND, INDEMNIFY, OR HOLD YOU HARMLESS FOR ANY CLAIMS ARISING
 *       FROM OR RELATED TO THE CODE; AND
 *   (D) WITH RESPECT TO YOUR EXERCISE OF ANY RIGHTS GRANTED TO YOU FOR THE CODE, CLOUDERA IS NOT LIABLE FOR ANY
 *       DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, PUNITIVE OR CONSEQUENTIAL DAMAGES INCLUDING, BUT NOT LIMITED
 *       TO, DAMAGES RELATED TO LOST REVENUE, LOST PROFITS, LOSS OF INCOME, LOSS OF BUSINESS ADVANTAGE OR
 *       UNAVAILABILITY, OR LOSS OR CORRUPTION OF DATA.
 */

var ngCommonHttp = require('@angular/common/http');
var ngCoreTesting = require('@angular/core/testing');

var ExtensionCreationComponent = require('@flow-designer/components/flow-designer-extension-creation');

var FdsCoreModule = require('@flow-design-system/core');
var FlowDesignerCoreModule = require('@flow-designer/modules/core');

describe('Platform Flow Designer Extension Creation Component', function () {
    var extensionCreationComponent;
    var fixture;

    beforeEach(function () {
        ngCoreTesting.TestBed.configureTestingModule({
            imports: [
                FdsCoreModule,
                FlowDesignerCoreModule,
                ngCommonHttp.HttpClientModule
            ]
        });

        fixture = ngCoreTesting.TestBed.createComponent(ExtensionCreationComponent);

        extensionCreationComponent = fixture.componentInstance;
        extensionCreationComponent.extensions = [];
        extensionCreationComponent.extensionType = "Processor";

        // Spy
        spyOn(extensionCreationComponent, 'filterExtensions').and.callThrough();

        // ngOnInit()
        fixture.detectChanges();
    });

    it('should create component', function () {
        //assertions
        expect(extensionCreationComponent).toBeDefined();
        expect(extensionCreationComponent.filterExtensions).toHaveBeenCalled();
        expect(extensionCreationComponent.filterExtensions.calls.count()).toEqual(1);
    });

    it('should sort extensions', function () {
        extensionCreationComponent.sortExtensions({
            sortable: true,
            name: 'description',
            sortOrder: 'DESC'
        });

        //assertions
        expect(extensionCreationComponent.activeColumn.name).toBe('description');
        expect(extensionCreationComponent.activeColumn.active).toBeTruthy();
        expect(extensionCreationComponent.filterExtensions).toHaveBeenCalled();
        expect(extensionCreationComponent.filterExtensions.calls.count()).toEqual(2);
    });

    it('should auto filter extensions', function () {
        extensionCreationComponent.autoFilterExtensions('test');

        //assertions
        expect(extensionCreationComponent.filterExtensions).toHaveBeenCalled();
        expect(extensionCreationComponent.filterExtensions.calls.count()).toEqual(2);
    });

    it('should select an extension', function () {
        extensionCreationComponent.select({
            checked: false,
            testProp: 'test'
        });

        //assertions
        expect(extensionCreationComponent.selectedExtension.checked).toBeTruthy();
        expect(extensionCreationComponent.selectedExtension.testProp).toBe('test');
        expect(extensionCreationComponent.filterExtensions.calls.count()).toEqual(1);
    });
});
