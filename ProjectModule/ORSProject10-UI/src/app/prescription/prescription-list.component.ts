import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-prescription-list',
  templateUrl: './prescription-list.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionListComponent extends BaseListCtl {

  public form = {
    error: false,
    message: null,
    preload: {
      name: [],
    },
    data: { id: null },

    searchParams: {
      name: null,
      date: "",
      decease: null,
      capacity: null,
    },
    searchMessage: null,
    list: [],
    pageNo: 0,
  };

  constructor(
    public locator: ServiceLocatorService,
    public route: ActivatedRoute,
    private httpClient: HttpClient
  ) {
    super(locator.endpoints.PRESCRIPTION, locator, route);
  }

  ngOnInit() {
    super.ngOnInit();
  }

  submit() {
    this.form.pageNo = 0;

    this.search();
  }

  search() {
    this.form.searchMessage = null;

    super.search();
  }
  validateNumericInput(event: KeyboardEvent) {
    const str = event.key;
    console.log(str);
    if (!/^\d$/.test(str)) {
      event.preventDefault();
    }
  }

}