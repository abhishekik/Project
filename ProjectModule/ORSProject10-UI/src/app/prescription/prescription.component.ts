import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.PRESCRIPTION, locator, route);
  }


  submit() {
    var _self = this;
    console.log("in submit");
    console.log(this.form);
    console.log(this.form.data);
    this.serviceLocator.httpService.post(
      this.api.save,
      this.form.data,
      function (res) {
        _self.form.message = "";
        _self.form.data.id = res.result.data;

        if (res.success) {
          _self.form.message = "Data is saved";
          _self.form.data.id = res.result.data;

          console.log(_self.form.data.id);
          console.log("----------Dheeraj----------.");
        } else {
          _self.form.error = true;
          if (res.result.inputerror) {
            _self.form.inputerror = res.result.inputerror;
          }
          _self.form.message = res.result.message;
        }
        _self.form.data.id = res.result.data;
        console.log("FORM", _self.form);
      }
    );
  }
  onUpload(userform: FormData) {
    this.submit();
    console.log(this.form.data.id + "---- after submit");
  }


  validate() {
    return this.validateForm(this.form.data);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.decease);
    flag = flag && validator.isNotNullObject(form.date);
    flag = flag && validator.isNotNullObject(form.capacity);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.decease = data.decease;
    form.date = data.date;
    form.capacity = data.capacity;
  
    console.log('Populated Form', form);
  }
}
